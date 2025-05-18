class EventEmitter {
    constructor() {
        this.events = new Map(); 
        this.subscriptions = []; 
    }

    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object} subscription with unsubscribe method
     */
    subscribe(eventName, callback) {
        if(!this.events.has(eventName)) {
            this.events.set(eventName, []);
        }
        this.events.get(eventName).push(callback);
        const subscriptionIndex = this.subscriptions.length;
        this.subscriptions.push({ eventName, callback, unsubscribed: false });

        return {
            unsubscribe: () => {
                if(this.subscriptions[subscriptionIndex].unsubscribed) {
                    return;
                }
                this.subscriptions[subscriptionIndex].unsubscribed = true;
                const listeners = this.events.get(eventName);
                const idx = listeners.indexOf(callback);
                if(idx !== -1) {
                    listeners.splice(idx, 1);
                }
                return undefined;
            }
        };
    }

    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array} results of callbacks
     */
    emit(eventName, args = []) {
        if (!this.events.has(eventName)) {
            return [];
        }
        const listeners = this.events.get(eventName);
        return listeners.map(cb => cb(...args));
    }
}

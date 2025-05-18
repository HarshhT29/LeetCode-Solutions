/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (Array.isArray(obj)) {
        return obj.map(compactObject).filter(item => Boolean(item));
    } else if (obj && typeof obj === "object") {
        const comp = {};
        for (const key in obj) {
            if (obj.hasOwnProperty(key)) {
                const val = compactObject(obj[key]);
                if (Boolean(val)) {
                    comp[key] = val;
                }
            }
        }
        return comp;
    } else {
        return obj;
    }
};

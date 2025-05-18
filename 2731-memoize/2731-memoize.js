/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = new Map();
    let callCount = 0;

    const memoized = function(...args) {
        const key = args.join(',');
        if(cache.has(key)) {
            return cache.get(key);
        }
        const res = fn(...args)
        cache.set(key, res);
        callCount++;
        return res;
    }

    memoized.getCallCount = () => {
        return callCount;
    }
    return memoized;
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */
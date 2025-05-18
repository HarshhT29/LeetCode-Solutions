/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    const result = {};
    for (const item of this) {
        const key = fn(item);
        if (result.hasOwnProperty(key)) {
            result[key].push(item);
        } else {
            result[key] = [item];
        }
    }
    return result;
};


/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
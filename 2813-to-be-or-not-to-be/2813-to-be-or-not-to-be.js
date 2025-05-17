/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {
    function toBe(a) {
        if(a!==val) {
            throw new Error("Not Equal");
        }
        return true;
    }
    function notToBe(b) {
        if(b===val) {
            throw new Error("Equal");
        } 
        return true;
    }
    return {toBe, notToBe};
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */
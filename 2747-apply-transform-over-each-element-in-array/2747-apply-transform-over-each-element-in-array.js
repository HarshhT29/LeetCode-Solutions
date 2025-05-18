/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    returnedArray = [];
    arr.forEach((ele, i) => {
        returnedArray[i] = fn(ele, i);
    })
    return returnedArray;
};
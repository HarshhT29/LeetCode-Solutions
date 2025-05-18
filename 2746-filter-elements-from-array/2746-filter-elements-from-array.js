/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let res = [];
    arr.forEach((ele, i) => {
        if(fn(ele, i)) {
            res.push(ele);
        }
    })
    return res;
};
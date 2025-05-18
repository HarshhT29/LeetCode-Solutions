/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        const results = [];
        let cnt = 0;
        
        functions.forEach((fn, i) => {
            try {
                fn()
                    .then(value => {
                        results[i] = value;
                        cnt++;
                        if(cnt == functions.length) {
                            resolve(results);
                        }
                    })
                    .catch(err => {
                        reject(err);
                    });
            } catch(err) {
                reject(err);
            }
        });
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */
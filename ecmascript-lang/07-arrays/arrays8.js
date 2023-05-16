
                                    // De Structuring

const nums = [10, 20, 30, 40, 50];

// let a, b;
// let something;

// left-hand side {}, [] (de-structuring)
let [a , b , ...something] = nums; // [10, 20, 30, 40, 50]
let [ k = 10, m = 20 , ...test] = [-5,undefined,30,40,50]; 

console.log(a);
console.log(b);
console.log(something);
console.log(k);
console.log(m);
console.log(test);

let x = 10;
let y = 20;
console.log("x = " , x, ", y = ", y);

[y, x]=[x, y];
console.log("x = " , x, ", y = ", y);
let arr1 = new Array();
console.log(arr1.length)

let arr2 = new Array(10);
console.log(arr2.length)

for (let i =0 ; i < arr2.length ; i++){
    console.log(arr2[i])
}

let arr3 = new Array(10,20,30,29)
console.log(arr3.length)

console.log("++++++++++++++++++++++++++++++++++++++++++++++++++")

for( let i = 0 ; i < arr3.length ; i++){
    console.log(arr3[i])
}

console.log("++++++++++++++++++++++++++++++++++++++++++++++++++")


let arr4 = [20,4,5,6,7,7,8,8,8,8,8]; // array literal == array initializer

console.log(Array.isArray(arr4))
console.log(arr4.length)
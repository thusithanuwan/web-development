let arr1 = [10,40,true,'somethig',{} ] // java scipt array do not has specific data type




/* 





*/




//Squre bracket notaion
console.log(arr1[0])
console.log(arr1[1])


console.log(arr1["1"])
console.log(arr1["3"])

// Iterating arrays
        //for....in (legacy)  - > can iterate properties of any object
        //for...of  (new)   -> can iterate values of any array

for(const property in arr1){
    console.log(property, ":",arr1[property]);
}

for(const value of arr1){
    console.log(value)
}
// Array API 
//adding
const myArray = [];
console.log(myArray.length)
console.log(Array.isArray(myArray))
console.log(Array.isArray({}))

myArray.push(10,20,30) // push = append
console.log(myArray)
myArray.push(40,50)
console.log(myArray)
console.log(myArray.length)


myArray.unshift(-10,5)  // unshift = prepend

console.log(myArray)

// splice (pos, 0 , insertvalue)
myArray.splice(2,0,450)  // shoud add '0' when we use splice otherwise it will remove
console.log(myArray)

myArray.splice(3,0,56,67,89)
console.log(myArray)

// Removing

myArray.pop();  // pop = remove from tail
console.log(myArray)
let removedItem = myArray.pop();
console.log(removedItem, myArray)

myArray.shift();  // shift = remove from head
console.log(myArray)
let remove = myArray.shift();
console.log(remove, myArray)


// splice (pos, delete count [1])
myArray.splice(2,3)
console.log(myArray)
let removedItems = myArray.splice(0,2)
console.log(removedItems, myArray)
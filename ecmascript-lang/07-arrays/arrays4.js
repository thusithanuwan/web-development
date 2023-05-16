let myArray = new Array(20);

// fill(value,starting pos, ending pos)
myArray.fill('dep',10,18)  //  can fill fixed size array , that means cannot fill empty size array
console.log(myArray)

// Replacing

myArray = [10,20,30,50]

// splice(pos, replace count, value set)
myArray.splice(2,1,25,40,90)
console.log(myArray)

console.log(myArray.includes(25))  // new
console.log(myArray.includes(100))

let index = myArray.indexOf(25)  // legacy
console.log(index)

myArray.splice(2,0,25,25,25)
console.log(myArray.indexOf(25))
console.log(myArray.lastIndexOf(25))

console.log(myArray.indexOf(68))

console.log("++++++++++++++++++++++++++++++++++++++++")

myArray.forEach(values => console.log(values))

let filteredArray = myArray.filter(values => values !=25 )  // return an array, except value 25
console.log(filteredArray)

let x = 0;
for (let value of filteredArray){
    value *= 10;
    filteredArray[x++] = value;
}
console.log(filteredArray)

let revampedArray = filteredArray.map(value => 'ijse')
console.log(revampedArray)
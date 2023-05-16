                                                // Concatnating

const arr1 = [10, 20, 30, 40, 50];
const arr2 = [60, 70, 80, 90, 100];
const arr3 = ['ijse', 'dep', 'absd', 'cmjd', true];
const arr4 = [[10, 20], 'something'];

const arryClone = arr1.slice();
console.log(arryClone)
arryClone.push(...arr2, ...arr3, ...arr4);
console.log(arryClone);

let finalResult = arr1.concat(arr2, arr3, arr4);
console.log(finalResult);

let contatArray = [...arr1, ...arr2, ...arr3, ...arr4];
console.log(contatArray);
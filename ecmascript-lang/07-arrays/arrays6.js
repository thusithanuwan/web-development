                                                    // Find object in an array

class Employee{
    constructor(id,name){
        this.id = id;
        this.name = name;
    }
}
// const employee = [];
// const empId = [1,2,3,4,5].map(v => 'E00'+v)
// const empNames = ['Kasun','supun','nipun','ruwan','nimal']

// for(let i = 0; i< empId.length ; i++){
//     employee.push(new Employee(empId[i],empNames[i]))
// }
// console.log(employee)

const employees = [1, 2, 3, 4, 5, 6]
        .map((value, i) => 
            new Employee(`E00${value}`, 
            ['Kasun', 'Supun', 'Upul', 'Upul', 'Ruwan', 'Nuwan'].at(i))
        );

const empObj = employees.find(value => value.name == 'Upul');    // After we found the perticular object it does not serach further
console.log(empObj);

const index = employees.findIndex(value => value.name == 'Upul');
console.log(index);

const lastIndex = employees.findLastIndex(value => value.name == 'Upul');
console.log(lastIndex);




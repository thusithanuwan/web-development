                                                // Sort Object array

let nums = [10, 20, 30, 40, 50];
console.log(nums);
nums.reverse();
console.log(nums);
nums.sort();
console.log(nums);

class Studet {
    constructor(id,name,mark){
        this.id = id;
        this.name = name;
        this.mark = mark;
    }
}
let student = [];
student.push(new Studet(1,'kasun',59))
student.push(new Studet(2,'supun',100))
student.push(new Studet(3,'nuwan',43))
student.push(new Studet(4,'ruwan',90))

student.sort();
console.log(student)

student.sort((a,b) => {
    if(a.mark < b.mark) return 1;
    else if (a.mark > b.mark) return -1;
    else return 0;
})
console.log(student)

console.log("++++++++++++++++++++++++++++++++++")

const arr = ["First","Second","Third"]
console.log(arr)

// cloning
const arrClone = arr.slice();
console.log(arrClone.reverse())
console.log(arr)


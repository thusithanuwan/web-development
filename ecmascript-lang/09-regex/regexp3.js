const regExp = /((E)(\d{3}))/g
const text = "kasun's id is E001 and he is a good employee"


const result = regExp.exec(text);
console.log(result)
console.log(result[0])
console.log(result[1])
console.log(result['index']);
console.log(result['input']);


console.log("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")

// /api/v1/customers/C\d{3}
const apiRegExp = /(.+)\/api\/v1\/customers\/(C\d{3})$/;

const url1 = "http://ijse.lk/api/v1/customers/C001"
const url2 = "http://ijse.lk/api/v1/items/I001"

// 
const res = apiRegExp.exec(url1)
console.log(res)


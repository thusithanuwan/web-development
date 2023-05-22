const regExp1 = new RegExp("^E\\d{3}$")
const regExp2 = /^E\d{3}$/

const text = ['E001','something','E002','Hi','E004 something', 'Test E005']
text.forEach(text => {
    console.log(text, '=',regExp2.test(text))
})

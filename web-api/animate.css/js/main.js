const txtId = document.getElementById('txt-id')
const txtName = document.getElementById('txt-name')
const btnValidate = document.getElementById('btn-validate')



const regExId = new RegExp('^E\\d{3}$')
const regExName = new RegExp('^[A-Za-z]+$')

btnValidate.addEventListener('click',()=>{
    const id = txtId.value;
    const name = txtName.value;
    let validated = true;
    txtName.classList.remove('invalid', 'animate__shakeX')
    txtId.classList.remove('invalid', 'animate__shakeX')
    
    if(!regExName.test(name.trim())){
        
        setTimeout(() => txtName.classList.add('invalid','animate__shakeX'), 0);
        txtName.select();
        validated = false;
    }

    if(!regExId.test(id.trim())){
        setTimeout(() => txtId.classList.add('invalid','animate__shakeX'), 0);
        txtId.select();
        validated = false;
    } 
    
    if(validated){
        alert("Valid Data!")
    }
})


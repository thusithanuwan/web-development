/* ? Module Level Variable,Constant*/
const btnSelectImage =  $('#btn-select-image')
const fileChooser =  $('#file-chooser')
const image = $('#image')
const fileName = $('#file-name')
const fileSie =  $('#file-size')
const btnUpload =  $('#btn-upload')
const progressBar =  $('#pgb')
const progress =  $('#progress')

/* ? Initialization Logic*/
btnUpload.attr('disabled','true')

/* ? Event Handlers , Timers*/
btnSelectImage.on('click', ()=> fileChooser.trigger('click'))

fileChooser.on('change', ()=> setImagePreview())

btnUpload.on('click', ()=> uploadImage())

/* ? Functions*/
function setImagePreview(){
    const fileList = fileChooser[0].files;
    if(!fileList.length) return;
    const imageFile = fileList[0]
    fileName.text(imageFile.name)
    fileSie.text(`${(imageFile.size / 1024).toFixed(2)}KBs`)

    /*! file reader API*/
    const fileReader = new FileReader();  // File Reader is an API that use to read files

    fileReader.addEventListener('load',(eventData)=>{
        image.css('background-image',`url(${fileReader.result})`)
        btnUpload.removeAttr('disabled')
    })
    fileReader.readAsDataURL(imageFile)
}

function uploadImage(){
    progressBar.css('width','0%')
    progress.text('0%')
}
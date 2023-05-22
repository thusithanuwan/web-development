const url = [   'http://ijse.lk', 
                'http://blog.ijse.lk/web/blog',
                'https://www.google.com/search',
                'https://ikman.lk',
                'http://google.uk/search/1=ijse',
                'https://www.daraz.in']

                
                
url.forEach(url => {
    const apiRegExp = /(?<pc>http[s]?):\/\/((.+)[.])?(?<dn>.+[.](?<td>[a-z]{2,4}))(\/.+)?/;
    const res = apiRegExp.exec(url)
    // console.log(res)

    // console.log(res[1])
    console.log("Top level Domains:",res.groups.td)
    console.log("Domain name:",res.groups.dn)
    console.log("Protocol:",res.groups.pc)
    console.log("+++++++++++++++++++++++++++++++++++++++++++++")                  
})

const text = [
    'S001-1245678987V-Kasun Sampath',
    'S002-1245678987v-Nuwan',
    'S003-1245678987v-Ruwan'
]

text.forEach(text => {
    const apiRegExp = /(?<id>S\d{3})[-](?<nic>\d{10}[vV])[-](?<name>[A-z ]+)/
    // const res  = apiRegExp.exec(text)  // Both give same result
    const res = text.match(apiRegExp)

    console.log("ID:\t",res.groups.id)
    console.log("NIC:\t",res.groups.nic)
    console.log("NAME:\t",res.groups.name)

    console.log("+++++++++++++++++++++++++++")


})
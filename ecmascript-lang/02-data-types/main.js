/* 
Data Types (Basic-Primitive)
Literals
typeof Operator
Variables (var,let - Ec6)
Constants (legacy,const - Ec6)
*/

/*boolean*/
console.log(true, false);

/*number*/
console.log(1025);
console.log(-1025);
console.log(10.25);
console.log(-10.25);
console.log(10.25e5);
console.log(10.25e-5);
console.log(0.3-0.2); // IEEE 754 (Just like java , c#)

console.log("+++++++++++++++++++++++++++++++++++++++")

console.log(0b010); // Binary
console.log(010);    // Octal (Legacy)
console.log(0o10);   // Octal (Recomended)

console.log(0xFF);  // Hexadecimal

console.log("+++++++++++++++++++++++++++++++++++++++")

console.log(Infinity, 10/0);
console.log(-Infinity, -10/0);
console.log(NaN, (10-'a'));     // Not a number


console.log("+++++++++++++++++++++++++++++++++++++++")

/* BigInt (2020-Ecma11) */
//  Use only when it needs
// No fix- bit-width
// Low performace compaired to number

console.log(BigInt(948759247395273492935));
console.log(5098523850802508054235032n);

console.log(0b101001);  // Binary
console.log(0o103571);  // Octal
console.log(0xFfFFn);    // Hexadicimal

console.log(10n + 10n);
console.log(10n + BigInt(3));  // Number -> BigInt, result = BigInt
console.log(Number(10n) + 8);   // BigInt -> Number, result = Number

console.log("+++++++++++++++++++++++++++++++++++++++")

/* String */

console.log("This is a String");
console.log('This is also a Strting');
console.log("This 'is' aloso a String");
console.log('This "is" also a String');

console.log(`                          
    This is a multiline String
    This is also called non-tagged template String, introduced in js6(2015)
    we can have some crazy ${10+15} shit here
    one more: \${(10+15) > 20}
    This technique is called "Text Interpolation"
    The syntax: \${valid js expression}
`);


console.log("+++++++++++++++++++++++++++++++++++++++")

/* null, undifine */
console.log(null);
console.log(undefined);
console.log(null==undefined);

console.log("+++++++++++++++++++++++++++++++++++++++")


/* Symbol (2015-Ecam6) */

console.log(Symbol());  // Description -> undefinned
console.log(Symbol('ijse'));  // Description -> ijse
console.log(Symbol('a') == Symbol('a'));



/* Variables */

var identifier;
identifier = 10;
console.log(identifier);
identifier = "ijse";
identifier = "true";
console.log(identifier);
let name = "Thusitha";


/* conatant */

Object.defineProperties(globalThis, 'PI', {
    vlaue: 3.24,
    writable: false,
    enumerable: false,
    configurable: false
})

console.log(PI)

// * Legacy (Mostly used among developers)
var DAYS_OF_WEEK =7;
console.log(DAYS_OF_WEEK);

const NUMBER_OF_DAYS_IN_YEAR = 366;
// NUMBER_OF_DAYS_IN_YEAR = 366;   Here we get an error
console.log(NUMBER_OF_DAYS_IN_YEAR);

/* type of operator */

/* syntax : typeof < valid js expression > : String */
let something = 10;
console.log(typeof something)
something = 10n;
console.log(typeof something)
something = 10.25;
console.log(typeof something)
something = 'I am a String'
console.log(typeof something)
something = "I am a String"
console.log(typeof something)
something = `I am non-tagged template string`
console.log(typeof something)
something = Symbol()
console.log(typeof something)
something = null
console.log(typeof something)     // This return obeject -> this is mistake by js, null is premitive type
something = undefined
console.log(typeof something)
console.log(typeof ('10'))
console.log(typeof (10 + 'ijse'))


console.log("+++++++++++++++++++++++++++++++++++++++")

/* String Conversion */

let str = "10.45"
console.log(typeof str)
let num1 = parseInt(str)
console.log(num1, typeof num1)
let num2 = parseFloat(str)
console.log(num2, typeof num2)
str = "10"
let num3 = BigInt(str)
console.log(num3, typeof num3)

let n = 10
console.log(typeof n)
n += ''
console.log(typeof n)
n = true
console.log(typeof n)
n += ''
console.log(typeof n)


let a = 10
console.log(typeof a)
a = a.toString()
console.log(typeof a)
a = true
console.log(typeof a)
a=a.toString()
console.log(typeof a)
a = 10.34
console.log(typeof a)
a = a.toString()
console.log(typeof a)






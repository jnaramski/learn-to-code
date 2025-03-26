let mdp = "AdeDe6ck!Ds";

let regexUpper = /[A-Z]/;
let regexLower = /[a-z]/;
let regexNumber = /\d/;
let regexLenght = /^.{8,}$/;

if (
  regexUpper.test(mdp) &&
  regexLower.test(mdp) &&
  regexNumber.test(mdp) &&
  regexLenght.test(mdp)
) {
  console.log("super");
} else {
  console.log("désol bro");
}

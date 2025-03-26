let listpwd = [{ password: "jdudeq" }, { password: "1234!5679" }];

function validatePassword() {
  let regex = /^[a-zA-Z0-9]{8,20}$/;

  for (let i = 0; i < listpwd.length; i++) {
    let password = listpwd[i].password;

    if (regex.test(password)) {
      console.log("le mot de passe est valide !");
    } else {
      console.log("le mot de passe n'est pas valide !");
    }
  }
}

validatePassword(listpwd);

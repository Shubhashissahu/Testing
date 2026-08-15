const express = require("express");

const app = express();


app.get("/profile",(req,res)=>{


    let username = req.query.name;


    // Vulnerable XSS

    res.send(
        "<h1>Hello "
        + username +
        "</h1>"
    );


});


app.listen(3000,()=>{

    console.log("Server running");

});
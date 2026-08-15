const express = require("express");

const app = express();

app.get("/profile", (req, res) => {

    const username = req.query.username;

    res.send("<h1>Welcome " + username + "</h1>");
});

app.listen(3000);
const express = require("express");
const bodyparser = require("body-parser");
const cors = require("cors");
const db = require("./query");
const path = require("path");
const app = express();

var distDir = __dirname + "/dist/";
app.use(express.static(__dirname + "/public"));
app.use(express.static(distDir));
const port = process.env.PORT || 3333;

app.use(cors());
app.use(bodyparser.json());
app.use(
  bodyparser.urlencoded({
    extended: true,
  })
);
//database endpoints will be here
app.get("/", (request, response) => {
  response.json({ info: "Node.js,Express, and Postgres API" });
});
app.listen(port, () => {
  console.log(`App running on port ${port}.`);
});

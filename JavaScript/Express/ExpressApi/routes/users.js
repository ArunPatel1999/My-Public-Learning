var express = require('express');
var router = express.Router();
const data=[
  {
    id:1,
    user:"lalit",
    age:20
  },
  {
    id:1,
    user:"lalit",
    age:20
  },
]
/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send("User",data);
  res.send('respond with a resource');
});

module.exports = router;

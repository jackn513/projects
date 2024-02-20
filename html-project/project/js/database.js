const {Client} = require('pg');

const client = new Client({
    host: "localhost",
    user: "postgres",
    port: 5432,
    password: "postgres1",
    database: "musicDB"

})

client.connect();

client.query(`Select * from album`, (err, res) => {
    if(!err){
        console.log(res.rows);
    } else{ 
        console.log(err.message);
    }
    client.end;
})
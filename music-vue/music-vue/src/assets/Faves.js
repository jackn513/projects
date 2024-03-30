const faves = [
    {
        "id": 1,
        "title": 'Caligula',
        "artist": "Lingua Ignota",
        "price": 7.99,
        "image": "./product.jpg"
    },
    {
        "id": 2, 
        "title": "Tapestry",
        "artist": "Carole King",
        "price": 7.99,
        "image": "./product.jpg",
    },
    {
        "id": 3,
        "title": "HOPELESSNESS",
        "artist": "ANOHNI",
        "price": 7.99,
        "image": "./product.jpg",
    },
    {
        "id": 4,
        "title": "Bewitched",
        "artist": "Laufey",
        "price": 7.99,
        "image": "./product.jpg",
    },
];

export default {
    getFaveData() {
        return faves;
    }
};

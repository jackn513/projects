const albums = [
    {
        title: 'Caligula',
        artistName: 'Lingua Ignota (Kristen Hayter)',
        label: 'Profound Lore',
        releaseDate: '2019-07-19',
        image: 'https://upload.wikimedia.org/wikipedia/en/c/c1/Caligula_by_Lingua_Ignota_cover_art.jpg',
        length: '66',
        price: 7.99
    },
    {
        title: 'Sinner Get Ready',
        artistName: 'Lingua Ignota (Kristen Hayter)',
        label: 'Sargent House',
        releaseDate: '2021-08-06',
        image: 'https://upload.wikimedia.org/wikipedia/en/3/35/Sinner_Get_Ready.png',
        length: '55',
        price: 7.99
    },
    {
        title: 'Oil of Every Pearls Un-Insides',
        artistName: 'SOPHIE',
        label: 'Ridge Valley Digital',
        releaseDate: '2017-06-14',
        image: 'https://upload.wikimedia.org/wikipedia/en/d/d0/Sophie_-_Oil_of_Every_Pearl%27s_Un-Insides.png',
        length: '40',
        price: 10.99
    },
    {
        title: 'Fossora',
        artistName: 'Björk',
        label: 'Sargent House',
        releaseDate: '2022-11-30',
        image: 'https://upload.wikimedia.org/wikipedia/en/b/b6/Fossora.png',
        length: '54',
        price: 14.99
    },
    {
        title: 'Nina Simone: The Montreux Years (Live)',
        artistName: 'Nina Simone',
        label: 'One Little Independent Records',
        releaseDate: '2021-05-28',
        image: 'https://m.media-amazon.com/images/I/91YL8F+wHRL._UF1000,1000_QL80_.jpg',
        length: '121',
        price: 15.99
    },
    {
        title: 'The American Project',
        artistName: 'Yuja Wang',
        label: 'BMG Rights Management (UK) Limited',
        releaseDate: '2023-03-10',
        image: 'https://m.media-amazon.com/images/I/81elXZwOQbL._UF1000,1000_QL80_.jpg',
        length: '42',
        price: 9.99
    },
    {
        title: 'A Symphonic Celebration...',
        artistName: 'Joe Hisaishi',
        label: 'Deutsche Grammophon GmgH, Berlin',
        releaseDate: '2023-06-30',
        image: 'https://cdn11.bigcommerce.com/s-rdecee92oy/products/43421/images/6102187/3dglp488122__60265.1704801456.500.750.jpg?c=2',
        length: '88',
        price: 15.99
    },
    {
        title: 'Blue',
        artistName: 'Joni Mitchell',
        label: 'Universal Music LLC',
        releaseDate: '1971-06-22',
        image: 'https://upload.wikimedia.org/wikipedia/en/e/e1/Bluealbumcover.jpg',
        length: '36',
        price: 17.99
    },
    {
        title: 'Tapestry',
        artistName: 'Carole King',
        label: 'Warner Records INC',
        releaseDate: '1971-02-10',
        image: 'https://upload.wikimedia.org/wikipedia/en/5/52/Carole_King_-_Tapestry.jpg',
        length: '45',
        price: 15.99
    },
    {
        title: 'HOPELESSNESS',
        artistName: 'ANOHNI',
        label: 'Ode Records',
        releaseDate: '2016-05-06',
        image: 'https://upload.wikimedia.org/wikipedia/en/1/19/Hopelessness_%28Front_Cover%29.png',
        length: '42',
        price: 10.99
    },
    {
        title: 'Crouching Tiger, Hidden Dragon',
        artistName: 'Yo-yo Ma',
        label: 'Secretly Canadian',
        releaseDate: '2000-11-14',
        image: 'https://upload.wikimedia.org/wikipedia/en/6/61/Crouching_Tiger_Hidden_Dragon_OST.jpg',
        length: '49',
        price: 14.99
    },
    {
        title: 'Paris',
        artistName: 'Hilary Hahn',
        label: 'BMG Rights Management (UK) Limited',
        releaseDate: '2021-03-05',
        image: 'https://images.universal-music.de/img/assets/508/508702/4/2048/hilary-hahn-paris.jpg',
        length: '53',
        price: 9.99
    },
    {
        title: 'Dance Fever (Complete Edition)',
        artistName: 'Florence Welch (Florence and the Machine)',
        label: 'Sony Music Entertainment',
        releaseDate: '2023-04-21',
        image: 'https://i.scdn.co/image/ab67616d0000b2733a10ef0d61ed15315d6b0ef3',
        length: '62',
        price: 14.99
    },
    {
        title: 'Melodrama',
        artistName: 'Lorde',
        label: 'Polydor Records',
        releaseDate: '2017-06-16',
        image: 'https://upload.wikimedia.org/wikipedia/en/b/b2/Lorde_-_Melodrama.png',
        length: '41',
        price: 7.99
    },
    {
        title: 'All My Demons Greeting Me as a Friend',
        artistName: 'AURORA',
        label: 'Universal Music New Zealand Limited',
        releaseDate: '2016-03-11',
        image: 'https://upload.wikimedia.org/wikipedia/en/5/59/Aurora_-_All_My_Demons_Greeting_Me_as_a_Friend.png',
        length: '47',
        price: 7.99
    },
    {
        title: 'Elgar',
        artistName: 'Sheku Kanneh-Mason',
        label: 'Glassnote Entertainment Group LLC',
        releaseDate: '2020-01-10',
        image: 'https://m.media-amazon.com/images/I/810aOXdvFqL._UF1000,1000_QL80_.jpg',
        length: '69',
        price: 7.99
    },
    {
        title: 'Visions',
        artistName: 'Grimes',
        label: 'Decca Classics',
        releaseDate: '2012-02-21',
        image: 'https://upload.wikimedia.org/wikipedia/en/c/c1/Grimes_-_Visions_album_cover.png',
        length: '50',
        price: 7.99
    },
    {
        title: 'Oral Fixation, Vol.2',
        artistName: 'Shakira',
        label: 'Secretly Canadian',
        releaseDate: '2005-11-28',
        image: 'https://upload.wikimedia.org/wikipedia/en/9/9e/Oral_Fixation_Vol._2.png',
        length: '50',
        price: 10.99
    },
    {
        title: 'Pearl',
        artistName: 'Janis Joplin',
        label: 'Secretly Canadian',
        releaseDate: '1971-01-11',
        image: 'https://upload.wikimedia.org/wikipedia/en/6/61/Janis_Joplin-Pearl_%28album_cover%29.jpg',
        length: '34',
        price: 14.99
    },
    {
        title: 'EL MAL QUERER',
        artistName: 'Rosalía',
        label: 'Arbutus Records',
        releaseDate: '2018-11-02',
        image: 'https://upload.wikimedia.org/wikipedia/en/e/e9/Rosalía_El_mal_querer.png',
        length: '30',
        price: 10.99
    },
    {
        title: 'Ultraviolence (Deluxe)',
        artistName: 'Lana Del Rey',
        label: 'Sony Music Entertainment',
        releaseDate: '2014-01-01',
        image: 'https://m.media-amazon.com/images/I/81ajxpblWYL._UF1000,1000_QL80_.jpg',
        length: '69',
        price: 15.99
    },
    {
        title: 'Un Verano Sin Ti',
        artistName: 'Bad Bunny',
        label: 'Columbia Records',
        releaseDate: '2022-05-06',
        image: 'https://upload.wikimedia.org/wikipedia/en/6/60/Bad_Bunny_-_Un_Verano_Sin_Ti.png',
        length: '82',
        price: 14.99
    },
    {
        title: 'MASSEDUCTION',
        artistName: 'St. Vincent (Annie Clark)',
        label: 'This Record Company Ltd.',
        releaseDate: '2017-10-13',
        image: 'https://upload.wikimedia.org/wikipedia/en/9/90/St_Vincent_-_Masseduction.png',
        length: '42',
        price: 9.99
    },
    {
        title: 'Goodbye Yellow Brick Road',
        artistName: 'Elton John',
        label: 'Rimas Entertainment',
        releaseDate: '1973-10-05',
        image: 'https://upload.wikimedia.org/wikipedia/en/8/86/Elton_John_-_Goodbye_Yellow_Brick_Road.jpg',
        length: '76',
        price: 15.99
    },
    {
        title: 'Bury Me At Makeout Creek',
        artistName: 'Mitski',
        label: 'Loma Vista Recordings',
        releaseDate: '2014-11-11',
        image: 'https://upload.wikimedia.org/wikipedia/en/9/95/Bury_Me_At_Makeout_Creek.jpg',
        length: '30',
        price: 9.99
    },
    {
        title: 'Tár',
        artistName: 'Hildur Goðnadottir',
        label: 'Dead Oceans',
        releaseDate: '2022-10-21',
        image: 'https://m.media-amazon.com/images/I/615Ja3MlyKL._UF1000,1000_QL80_.jpg',
        length: '64',
        price: 15.99
    },
    {
        title: 'Magdelene',
        artistName: 'FKA Twigs (Tahlia Barnett)',
        label: 'Focus Features LLC',
        releaseDate: '2019-11-08',
        image: 'https://upload.wikimedia.org/wikipedia/en/9/91/FKATwigs_Magdalene.png',
        length: '39',
        price: 9.99
    },
    {
        title: 'Glassworks & Interview with Philip Glass',
        artistName: 'Philip Glass',
        label: 'Secretly Canadian',
        releaseDate: '2016-12-09',
        image: 'https://i.discogs.com/ci2rpiKcN0Ril-WTb91kYICCZ5L3qn74XFNwZiOBihI/rs:fit/g:sm/q:90/h:574/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNzY3/ODAtMTI3NTYxOTEz/Mi5qcGVn.jpeg',
        length: '88',
        price: 15.99
    },
    {
        title: 'Tonya Harding',
        artistName: 'Sufjan Stevens',
        label: 'Young (FKA Young Turks)',
        releaseDate: '2017-12-08',
        image: 'https://upload.wikimedia.org/wikipedia/en/4/4f/Sufjan_Stevens_%22Tonya_Harding%22.jpg',
        length: '9',
        price: 5.99
    },
    {
        title: 'Awaken, My Love!',
        artistName: 'Childish Gambino (Donald Glover)',
        label: 'XL Recordings LC',
        releaseDate: '2016-12-02',
        image: 'https://upload.wikimedia.org/wikipedia/en/1/10/Childish_Gambino_-_Awaken%2C_My_Love%21.png',
        length: '49',
        price: 9.99
    },
    {
        title: 'Punisher',
        artistName: 'Phoebe Bridges',
        label: 'Loma Vista Recordings',
        releaseDate: '2020-06-17',
        image: 'https://upload.wikimedia.org/wikipedia/en/2/23/Phoebe_Bridgers_Punisher_%282020%29.png',
        length: '41',
        price: 7.99
    },
    {
        title: 'The Dune SketchBook',
        artistName: 'Hans Zimmer',
        label: 'McDJ Entertainment',
        releaseDate: '2021-09-03',
        image: 'https://upload.wikimedia.org/wikipedia/en/6/67/The_Dune_Sketchbook_%28Music_from_the_Soundtrack%29_cover.jpg',
        length: '102',
        price: 15.99
    },
    {
        title: 'Shabrang',
        artistName: 'Sevdaliza',
        label: 'Debay Sounds LLC',
        releaseDate: '2020-08-28',
        image: 'https://upload.wikimedia.org/wikipedia/en/d/d4/Sevdaliza_-_Shabrang.jpg',
        length: '62',
        price: 9.99
    },
    {
        title: 'Græ',
        artistName: 'Moses Sumney',
        label: 'WaterTower Music',
        releaseDate: '2020-05-15',
        image: 'https://upload.wikimedia.org/wikipedia/en/4/49/Græ_%28Moses_Sumney%29.png',
        length: '66',
        price: 7.99
    },
    {
        title: 'Again',
        artistName: 'Oneohtrix Point Never (Daniel Lopatin)',
        label: 'Twisted Elegance',
        releaseDate: '2023-09-29',
        image: 'https://upload.wikimedia.org/wikipedia/en/d/d3/Oneohtrix_Point_Never_-_Again.png',
        length: '57',
        price: 7.99
    }
];

export default {
    getAlbumData() {
        return albums;
    }
};

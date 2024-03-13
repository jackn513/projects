const albums = [
    {
        title: 'Caligula',
        artistName: 'Lingua Ignota (Kristen Hayter)',
        label: 'Profound Lore',
        releaseDate: '2019-07-19',
        image: 'https://en.wikipedia.org/wiki/File:Caligula_by_Lingua_Ignota_cover_art.jpg',
        length: '66',
        price: 7.99
    },
    {
        title: 'Sinner Get Ready',
        artistName: 'Lingua Ignota (Kristen Hayter)',
        label: 'Sargent House',
        releaseDate: '2021-08-06',
        length: '55',
        price: 7.99
    },
    {
        title: 'Oil of Every Pearls Un-Insides',
        artistName: 'SOPHIE',
        label: 'Ridge Valley Digital',
        releaseDate: '2017-06-14',
        length: '40',
        price: 10.99
    },
    {
        title: 'Fossora',
        artistName: 'Björk',
        label: 'Sargent House',
        releaseDate: '2022-11-30',
        length: '54',
        price: 14.99
    },
    {
        title: 'Nina Simone: The Montreux Years (Live)',
        artistName: 'Nina Simone',
        label: 'One Little Independent Records',
        releaseDate: '2021-05-28',
        length: '121',
        price: 15.99
    },
    {
        title: 'The American Project',
        artistName: 'Yuja Wang',
        label: 'BMG Rights Management (UK) Limited',
        releaseDate: '2023-03-10',
        length: '42',
        price: 9.99
    },
    {
        title: 'A Symphonic Celebration...',
        artistName: 'Joe Hisaishi',
        label: 'Deutsche Grammophon GmgH, Berlin',
        releaseDate: '2023-06-30',
        length: '88',
        price: 15.99
    },
    {
        title: 'Blue',
        artistName: 'Joni Mitchell',
        label: 'Universal Music LLC',
        releaseDate: '1971-06-22',
        length: '36',
        price: 17.99
    },
    {
        title: 'Tapestry',
        artistName: 'Carole King',
        label: 'Warner Records INC',
        releaseDate: '1971-02-10',
        length: '45',
        price: 15.99
    },
    {
        title: 'HOPELESSNESS',
        artistName: 'ANOHNI',
        label: 'Ode Records',
        releaseDate: '2016-05-06',
        length: '42',
        price: 10.99
    },
    {
        title: 'Crouching Tiger, Hidden Dragon',
        artistName: 'Yo-yo Ma',
        label: 'Secretly Canadian',
        releaseDate: '2000-11-14',
        length: '49',
        price: 14.99
    },
    {
        title: 'Paris',
        artistName: 'Hilary Hahn',
        label: 'BMG Rights Management (UK) Limited',
        releaseDate: '2021-03-05',
        length: '53',
        price: 9.99
    },
    {
        title: 'Dance Fever (Complete Edition)',
        artistName: 'Florence Welch (Florence and the Machine)',
        label: 'Sony Music Entertainment',
        releaseDate: '2023-04-21',
        length: '62',
        price: 14.99
    },
    {
        title: 'Melodrama',
        artistName: 'Lorde',
        label: 'Polydor Records',
        releaseDate: '2017-06-16',
        length: '41',
        price: 7.99
    },
    {
        title: 'All My Demons Greeting Me as a Friend',
        artistName: 'AURORA',
        label: 'Universal Music New Zealand Limited',
        releaseDate: '2016-03-11',
        length: '47',
        price: 7.99
    },
    {
        title: 'Elgar',
        artistName: 'Sheku Kanneh-Mason',
        label: 'Glassnote Entertainment Group LLC',
        releaseDate: '2020-01-10',
        length: '69',
        price: 7.99
    },
    {
        title: 'Visions',
        artistName: 'Grimes',
        label: 'Decca Classics',
        releaseDate: '2012-02-21',
        length: '50',
        price: 7.99
    },
    {
        title: 'Oral Fixation, Vol.2',
        artistName: 'Shakira',
        label: 'Secretly Canadian',
        releaseDate: '2005-11-28',
        length: '50',
        price: 10.99
    },
    {
        title: 'Pearl',
        artistName: 'Janis Joplin',
        label: 'Secretly Canadian',
        releaseDate: '1971-01-11',
        length: '34',
        price: 14.99
    },
    {
        title: 'EL MAL QUERER',
        artistName: 'Rosalía',
        label: 'Arbutus Records',
        releaseDate: '2018-11-02',
        length: '30',
        price: 10.99
    },
    {
        title: 'Ultraviolence (Deluxe)',
        artistName: 'Lana Del Rey',
        label: 'Sony Music Entertainment',
        releaseDate: '2014-01-01',
        length: '69',
        price: 15.99
    },
    {
        title: 'Un Verano Sin Ti',
        artistName: 'Bad Bunny',
        label: 'Columbia Records',
        releaseDate: '2022-05-06',
        length: '82',
        price: 14.99
    },
    {
        title: 'MASSEDUCTION',
        artistName: 'St. Vincent (Annie Clark)',
        label: 'This Record Company Ltd.',
        releaseDate: '2017-10-13',
        length: '42',
        price: 9.99
    },
    {
        title: 'Goodbye Yellow Brick Road (2014 Remaster)',
        artistName: 'Elton John',
        label: 'Rimas Entertainment',
        releaseDate: '1973-10-05',
        length: '76',
        price: 15.99
    },
    {
        title: 'Bury Me At Makeout Creek',
        artistName: 'Mitski',
        label: 'Loma Vista Recordings',
        releaseDate: '2014-11-11',
        length: '30',
        price: 9.99
    },
    {
        title: 'Tár',
        artistName: 'Hildur Goðnadottir',
        label: 'Dead Oceans',
        releaseDate: '2022-10-21',
        length: '64',
        price: 15.99
    },
    {
        title: 'Magdelene',
        artistName: 'FKA Twigs (Tahlia Barnett)',
        label: 'Focus Features LLC',
        releaseDate: '2019-11-08',
        length: '39',
        price: 9.99
    },
    {
        title: 'Glassworks & Interview with Philip Glass',
        artistName: 'Philip Glass',
        label: 'Secretly Canadian',
        releaseDate: '2016-12-09',
        length: '88',
        price: 15.99
    },
    {
        title: 'Tonya Harding',
        artistName: 'Sufjan Stevens',
        label: 'Young (FKA Young Turks)',
        releaseDate: '2017-12-08',
        length: '9',
        price: 5.99
    },
    {
        title: 'Awaken, My Love!',
        artistName: 'Childish Gambino (Donald Glover)',
        label: 'XL Recordings LC',
        releaseDate: '2016-12-02',
        length: '49',
        price: 9.99
    },
    {
        title: 'Punisher',
        artistName: 'Phoebe Bridges',
        label: 'Loma Vista Recordings',
        releaseDate: '2020-06-17',
        length: '41',
        price: 7.99
    },
    {
        title: 'The Dune SketchBook',
        artistName: 'Hans Zimmer',
        label: 'McDJ Entertainment',
        releaseDate: '2021-09-03',
        length: '102',
        price: 15.99
    },
    {
        title: 'Shabrang',
        artistName: 'Sevdaliza',
        label: 'Debay Sounds LLC',
        releaseDate: '2020-08-28',
        length: '62',
        price: 9.99
    },
    {
        title: 'Græ',
        artistName: 'Moses Sumney',
        label: 'WaterTower Music',
        releaseDate: '2020-05-15',
        length: '66',
        price: 7.99
    },
    {
        title: 'Again',
        artistName: 'Oneohtrix Point Never (Daniel Lopatin)',
        label: 'Twisted Elegance',
        releaseDate: '2023-09-29',
        length: '57',
        price: 7.99
    }
];

export default {
    getAlbumData() {
        return albums;
    }
};

const albums = [
    {
        id: 1,
        title: 'Caligula',
        artistName: 'Lingua Ignota (Kristen Hayter)',
        label: 'Profound Lore',
        releaseDate: '2019',
        image: 'https://m.media-amazon.com/images/I/6195neWWzPL._UF1000,1000_QL80_.jpg',
        length: '66',
        price: 7.99,
        trackList: [
            "Faithful Servant Friend of Christ", "Do You Doubt Me Traitor", "Butcher of the World", "May Failure Be Your Noose", "Fragrant is My Flower'd Crown", "If the Poison Won't Take You My Dogs Will", "Day of Tears and Mourning", "Sorrow! Sorrow! Sorrow!", "Spite Alone Holds Me Aloft", "F******g DeathDealer", "I Am the Beast"
        ]
        
    },
    {
        id: 2,
        title: 'Sinner Get Ready',
        artistName: 'Lingua Ignota (Kristen Hayter)',
        label: 'Sargent House',
        releaseDate: '2021',
        image: 'https://m.media-amazon.com/images/I/91oQ4fEl4BS._UF1000,1000_QL80_.jpg',
        length: '55',
        price: 7.99,
        trackList: [
            "The Order of Spiritual Virgins",
            "I Who Bend the Tall Grasses",
            "Man is Like a Spring Flower",
            "Many Hands",
            "Pennsylvania Furnace",
            "Repent Now Confess Now",
            "The Solitary Brethren of Ephrata",
            "God Gave Me No Name (No Thing Can Hide From My Flame)"
          ]
    },
    {
        id: 3,
        title: 'Oil of Every Pearls Un-Insides',
        artistName: 'SOPHIE',
        label: 'Ridge Valley Digital',
        releaseDate: '2017',
        image: 'https://media.pitchfork.com/photos/648747aaaed875e699bc73ed/master/pass/Sophie.jpg',
        length: '40',
        price: 10.99,
        trackList: [
            "It's Okay to Cry",
            "Ponyboy",
            "Faceshopping",
            "Is It Cold in the Water?",
            "Infatuation",
            "Not Okay",
            "Pretending",
            "Immaterial",
            "Whole New World/Pretend World"
          ]
    },
    {
        id: 4,
        title: 'Fossora',
        artistName: 'Björk',
        label: 'Sargent House',
        releaseDate: '2022',
        image: 'https://media.pitchfork.com/photos/630f5a82d81b4a1c03943188/master/pass/Bjork-Fossora.jpg',
        length: '54',
        price: 14.99,
        trackList: [
            'Atopos',
            'Ovule',
            'Mycelia',
            'Sorrowful Soil',
            'Ancestress (feat. Sindri Eldon)',
            'Fagurt Et Í Fjörðum',
            'Victimhood',
            'Allow (feat. Emilie Nicolas)',
            'Fungal City (feat. serpentwithfeet)',
            'Trölla Gabba (feat.Kasimyn)',
            'Freefall',
            'Fossora (feat. Kasimyn)',
            "Her Mother's House (feat. ísadóra bjarkardóttir barney)"
        ]
    },
    {
        id: 5,
        title: 'Nina Simone: The Montreux Years (Live)',
        artistName: 'Nina Simone',
        label: 'One Little Independent Records',
        releaseDate: '2021',
        image: 'https://m.media-amazon.com/images/I/91YL8F+wHRL._UF1000,1000_QL80_.jpg',
        length: '121',
        price: 15.99,
        trackList: [
            "Someone to Watch Over Me (Intro) (Live At Casino Montreux, 10th July 1987)",
            "Backlash Blues (Live At Casino Montreux, 3rd July 1976)",
            "I Wish I Knew How It Would Feel to Be Free (Live - Montreux Jazz Festival 1976)",
            "See-Line Woman (Live At Casino Montreux, 13th July 1990)",
            "Little Girl Blue, Pt. 1 and 2 (Live - Montreux Jazz Festival 1976)",
            "Don't Smoke in Bed (Live At Casino Montreux, 13th July 1990)",
            "Stars (Live At Casino Montreux, 3rd July 1976)",
            "What a Little Moonlight Can Do (Live At Casino Montreux, 13th July 1990)",
            "African Mailman (Live At Casino Montreux, 3rd July 1976)",
            "Four Women (Live - Montreux Jazz Festival 1990)",
            "No Woman No Cry (Live At Casino Montreux, 13th July 1990)",
            "Liberian Calypso (Live At Casino Montreux, 13th July 1990)",
            "Ne Me Quitte Pas (Live At Casino Montreux, 13th July 1990)",
            "Montreux Blues (Live At Casino Montreux, 19th July 1981)",
            "My Baby Just Cares for Me (Live At Casino Montreux, 13th July 1990)",
            "Intro (Live At Casino Kursaal, 16th June 1968)",
            "Go to Hell (Live At Casino Kursaal, 16th June 1968)",
            "Just in Time (Live At Casino Kursaal, 16th June 1968)",
            "When I Was a Young Girl (Live At Casino Kursaal, 16th June 1968)",
            "Don't Let Me Be Misunderstood (Live At Casino Kursaal, 16th June 1968)",
            "Ne Me Quitte Pas (Live At Casino Kursaal, 16th June 1968)",
            "To Love Somebody (Live At Casino Kursaal, 16th June 1968)",
            "Backlash Blues (Live At Casino Kursaal, 16th June 1968)",
            "The House of the Rising Sun (Live At Casino Kursaal, 16th June 1968)",
            "See-Line Woman (Live At Casino Kursaal, 16th June 1968)",
            "Please Read Me (Live At Casino Kursaal, 16th June 1968)",
            "Ain't Got No, I Got Life (Live At Casino Kursaal, 16th June 1968)",
            "Gin House Blues (Live At Casino Kursaal, 16th June 1968)",
            "I Wish I Knew How It Would Feel to Be Free (Live At Casino Kursaal, 16th June 1968)"
        ],
    },
    {
        id: 6,
        title: 'The American Project',
        artistName: 'Yuja Wang',
        label: 'BMG Rights Management (UK) Limited',
        releaseDate: '2023',
        image: 'https://m.media-amazon.com/images/I/81elXZwOQbL._UF1000,1000_QL80_.jpg',
        length: '42',
        price: 9.99,
        trackList: [
            "You Come Here Often?",
            "I. Overture: Swing",
            "II. Cadenza I",
            "III. Exposition",
            "IV. Orchestra Break",
            "V. Exploration",
            "VI. Cadenza II",
            "VII. Relaxed",
            "VIII. Solos",
            "IX. Cadenza III",
            "X. Return: Swing",
            "XI. Cadenza IV and Coda"
        ]
    },
    {
        id: 7,
        title: 'A Symphonic Celebration...',
        artistName: 'Joe Hisaishi',
        label: 'Deutsche Grammophon GmgH, Berlin',
        releaseDate: '2023',
        image: 'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/250086c8-d911-4c55-b617-bf2686799d02.jpg',
        length: '88',
        price: 15.99,
        trackList: [
            "Nausicaä of the Valley of the Wind",
            "Kiki's Delivery Service",
            "Princess Mononoke",
            "The Wind Rises",
            "Ponyo on the Cliff By the Sea",
            "Castle in the Sky",
            "Porco Rosso",
            "Howl's Moving Castle",
            "Spirited Away",
            "My Neighbor Totoro"
        ]

    },
    {
        id: 8,
        title: 'Blue',
        artistName: 'Joni Mitchell',
        label: 'Universal Music LLC',
        releaseDate: '1971',
        image: 'https://m.media-amazon.com/images/I/81baUpgSr9L._UF1000,1000_QL80_.jpg',
        length: '36',
        price: 17.99,
        trackList: [
            "All I Want",
            "My Old Man",
            "Little Green",
            "Carey",
            "Blue",
            "California",
            "This Flight Tonight",
            "River",
            "A Case of You",
            "The Last Time I Saw Richard"
        ]

    },
    {
        id: 9,
        title: 'Tapestry',
        artistName: 'Carole King',
        label: 'Warner Records INC',
        releaseDate: '1971',
        image: 'https://media.pitchfork.com/photos/5df90fbc1dc57a00089529be/master/pass/caroleking.jpg',
        length: '45',
        price: 15.99,
        trackList: [
            "I Feel the Earth Move",
            "So Far Away",
            "It's Too Late",
            "Home Again",
            "Beautiful",
            "Way Over Yonder",
            "You've Got a Friend",
            "Where You Lead",
            "Will You Love Me Tomorrow?",
            "Smackwater Jack",
            "Tapestry",
            "(You Make Me Feel Like) A Natural Woman",
            "Out in the Cold",
            "Smackwater Jack"
        ]
    },
    {
        id: 10,
        title: 'HOPELESSNESS',
        artistName: 'ANOHNI',
        label: 'Ode Records',
        releaseDate: '2016',
        image: 'https://m.media-amazon.com/images/I/71UKENg5yeL._UF1000,1000_QL80_.jpg',
        length: '42',
        price: 10.99,
        trackList: [
            "Drone Bomb Me",
            "4 Degrees",
            "Watch Me",
            "Execution",
            "I Don't Love You Anymore",
            "Obama",
            "Violent Man",
            "Why Did You Separate Me from the Earth?",
            "Crisis",
            "Hopelessness",
            "Marrow"
        ]
    },
    {
        id: 11,
        title: 'Crouching Tiger, Hidden Dragon',
        artistName: 'Yo-yo Ma',
        label: 'Secretly Canadian',
        releaseDate: '2000',
        image: 'https://m.media-amazon.com/images/I/81N0mpvB47L._UF1000,1000_QL80_.jpg',
        length: '49',
        price: 14.99,
        trackList: [
            "Crouching Tiger, Hidden Dragon",
            "The Eternal Vow",
            "A Wedding Interrupted",
            "Night Fight",
            "Silk Road",
            "To the South",
            "Through the Bamboo Forest",
            "The Encounter",
            "Desert Capriccio",
            "In the Old Temple",
            "Yearning of the Sword",
            "Sorrow",
            "Farewell",
            "A Love Before Time",
            "A Love Before Time - CoCo Lee"
        ]
    },
    {
        id: 12,
        title: 'Paris',
        artistName: 'Hilary Hahn',
        label: 'BMG Rights Management (UK) Limited',
        releaseDate: '2021',
        image: 'https://images.universal-music.de/img/assets/508/508702/4/2048/hilary-hahn-paris.jpg',
        length: '53',
        price: 9.99,
        trackList: [
            "Poème Op. 25 for Violin and Orchestra - Ernest Chausson (1855-1899)",
            "Concerto for Violin and Orchestra No. 1 in D Major Op. 19 - Sergei Prokofiev (1891-1953)",
            "2 I. Andantino - Andante Assai",
            "3 II. Scherzo. Vivacissimo",
            "4 III. Moderato - Allegro Moderato - Moderato - Più Tranquillo",
            "Dedicated to Hilary Hahn · World Première Recording",
            "5 1. Sérénade Pour Mon Amour. Moderato - Einojuhani Rautavaara (1928-2016)",
            "6 2. Sérénade Pour la Vie. Andante Assai - Comodo - Agitato"
        ]
    },
    {
        id: 13,
        title: 'Dance Fever (Complete Edition)',
        artistName: 'Florence Welch (Florence and the Machine)',
        label: 'Sony Music Entertainment',
        releaseDate: '2023',
        image: 'https://i.scdn.co/image/ab67616d0000b2733a10ef0d61ed15315d6b0ef3',
        length: '62',
        price: 14.99,
        trackList: [
            "King",
            "Free",
            "Choreomania",
            "Back In Town",
            "Girls Against God",
            "Dream Girl Evil",
            "Prayer Factory",
            "Cassandra",
            "Heaven Is Here",
            "Daffodil",
            "My Love",
            "Restraint",
            "The Bomb",
            "Mermaids",
            "Morning Elvis",
            "King (Poem Version)",
            "My Love (Poem Version)",
            "Cassandra (Poem Version)"
        ]
    },
    {
        id: 14,
        title: 'Melodrama',
        artistName: 'Lorde',
        label: 'Polydor Records',
        releaseDate: '2017',
        image: 'https://m.media-amazon.com/images/I/71fwgxq0wML._UF1000,1000_QL80_.jpg',
        length: '41',
        price: 7.99,
        trackList: [
            "Green Light",
            "Sober",
            "Homemade Dynamite",
            "The Louvre",
            "Liability",
            "Hard Feelings/Loveless",
            "Sober II (Melodrama)",
            "Writer in the Dark",
            "Supercut",
            "Liability (Reprise)",
            "Perfect Places"
        ]        
    },
    {
        id: 15,
        title: 'All My Demons Greeting Me as a Friend',
        artistName: 'AURORA',
        label: 'Universal Music New Zealand Limited',
        releaseDate: '2016',
        image: 'https://m.media-amazon.com/images/I/51Gog8m1x8L._UF1000,1000_QL80_.jpg',
        length: '47',
        price: 7.99,
        trackList: [
            "Runaway",
            "Conqueror",
            "Running with the Wolves",
            "Lucky",
            "Winter Bird",
            "I Went Too Far",
            "Through the Eyes of a Child",
            "Warrior",
            "Murder Song",
            "Home",
            "Under the Water",
            "Black Water Lilies"
        ]        
    },
    {
        id: 16,
        title: 'Elgar',
        artistName: 'Sheku Kanneh-Mason',
        label: 'Glassnote Entertainment Group LLC',
        releaseDate: '2020',
        image: 'https://m.media-amazon.com/images/I/810aOXdvFqL._UF1000,1000_QL80_.jpg',
        length: '69',
        price: 7.99,
        trackList: [
            "Introduction and Allegro for Strings, Op. 47",
            "Cello Concerto in E Minor, Op. 85: I. Adagio - Moderato",
            "Cello Concerto in E Minor, Op. 85: II. Lento - Allegro molto",
            "Cello Concerto in E Minor, Op. 85: III. Adagio",
            "Cello Concerto in E Minor, Op. 85: IV. Allegro - Moderato - Allegro, ma non troppo - Poco più lento - Adagio"
        ]
    },
    {
        id: 17,
        title: 'Visions',
        artistName: 'Grimes',
        label: 'Decca Classics',
        releaseDate: '2012',
        image: 'https://m.media-amazon.com/images/I/71miHIEI9IL._UF1000,1000_QL80_.jpg',
        length: '50',
        price: 7.99,
        trackList: [
            "Infinite Love Without Fulfilment",
            "Genesis",
            "Oblivion",
            "Eight",
            "Circumambient",
            "Vowels = Space and Time",
            "Visiting Statue",
            "Be A Body",
            "Colour of Moonlight (Antiochus) [feat. Doldrums]",
            "Symphonia IX (My Wait Is U)",
            "Nightmusic (feat. Majical Cloudz)",
            "Skin",
            "Know the Way (Outro)"
        ]
        
    },
    {
        id: 18,
        title: 'Oral Fixation, Vol.2',
        artistName: 'Shakira',
        label: 'Secretly Canadian',
        releaseDate: '2005',
        image: 'https://m.media-amazon.com/images/I/81dpo1ksHYL._UF1000,1000_QL80_.jpg',
        length: '50',
        price: 10.99,
        trackList: [
            "How Do You Do",
            "Illegal (feat. Carlos Santana)",
            "Hips Don't Lie (feat. Wyclef Jean)",
            "Animal City",
            "Don't Bother",
            "The Day and the Time (feat. Gustavo Cerati)",
            "Dreams for Plans",
            "Hey You",
            "Your Embrace",
            "Costume Makes the Clown",
            "Something",
            "Timor"
        ]
        

    },
    {
        id: 19,
        title: 'Pearl',
        artistName: 'Janis Joplin',
        label: 'Secretly Canadian',
        releaseDate: '1971',
        image: 'https://m.media-amazon.com/images/I/810nwQrRf0L._UF1000,1000_QL80_.jpg',
        length: '34',
        price: 14.99,
        trackList: [
            "Move Over",
            "Cry Baby",
            "A Woman Left Lonely",
            "Half Moon",
            "Buried Alive in the Blues",
            "My Baby",
            "Me and Bobby McGee",
            "Mercedes Benz",
            "Trust Me",
            "Get It While You Can"
        ]
    },
    {
        id: 20,
        title: 'EL MAL QUERER',
        artistName: 'Rosalía',
        label: 'Arbutus Records',
        releaseDate: '2018',
        image: 'https://media.pitchfork.com/photos/64b194c24d755736fe4b0d2a/master/pass/Rosalia-El-Mal-Querer.jpg',
        length: '30',
        price: 10.99,
        trackList: [
            "Malamente",
            "Que No Salga La Luna",
            "Pienso En Tu Mirá",
            "De Aquí No Sales",
            "Reniego",
            "Preso",
            "Di Mi Nombre",
            "Bagdad",
            "Nana",
            "Maldición",
            "A Ningún Hombre"
        ]
        
    },
    {
        id: 21,
        title: 'Ultraviolence (Deluxe)',
        artistName: 'Lana Del Rey',
        label: 'Sony Music Entertainment',
        releaseDate: '2014',
        image: 'https://m.media-amazon.com/images/I/81ajxpblWYL._UF1000,1000_QL80_.jpg',
        length: '69',
        price: 15.99,
        trackList: [
            "Cruel World",
            "Ultraviolence",
            "Shades of Cool",
            "Brooklyn Baby",
            "West Coast",
            "Sad Girl",
            "Pretty When You Cry",
            "Money Power Glory",
            "Fucked My Way Up to the Top",
            "Old Money",
            "The Other Woman",
            "Black Beauty",
            "Guns and Roses",
            "Florida Kilos"
        ]
        
    },
    {
        id: 22, 
        title: 'Un Verano Sin Ti',
        artistName: 'Bad Bunny',
        label: 'Columbia Records',
        releaseDate: '2022',
        image: 'https://m.media-amazon.com/images/I/81C6LV7yNTL._UF1000,1000_QL80_.jpg',
        length: '82',
        price: 14.99,
        trackList: [
            "Un Verano Sin Ti",
            "Si Estuviesemos Juntos",
            "Hablamos Mañana",
            "Amorfoda",
            "Solo De Mí",
            "Me Importa Un Carajo",
            "Tú No Metes Cabra",
            "Chambea",
            "Soy Peor",
            "No Te Hagas",
            "Sensualidad",
            "Estamos Bien",
            "La Noche De Anoche",
            "Callaíta",
            "Te Mudaste",
            "Yo Perreo Sola",
            "Ignorantes",
            "Vete",
            "Hoy Cobré",
            "Diles",
            "Safaera",
            "Una Vez",
            "La Difícil",
            "Soy El Diablo",
            "La Santa",
            "Pero Ya No",
            "Si Veo A Tu Mamá",
            "La Zona",
            "La Canción",
            "Ignorantes",
            "Yo Perreo Sola (Remix)"
        ]
        
    },
    {
        id: 23,
        title: 'MASSEDUCTION',
        artistName: 'St. Vincent (Annie Clark)',
        label: 'This Record Company Ltd.',
        releaseDate: '2017',
        image: 'https://m.media-amazon.com/images/I/714oYtrkdNL._UF1000,1000_QL80_.jpg',
        length: '42',
        price: 9.99,
        trackList: [
            "Hang on Me",
            "Pills",
            "Masseduction",
            "Sugarboy",
            "Los Ageless",
            "Happy Birthday, Johnny",
            "Savior",
            "New York",
            "Fear the Future",
            "Young Lover",
            "Dancing with a Ghost",
            "Slow Disco",
            "Smoking Section"
        ]
        

    },
    {
        id: 24,
        title: 'Goodbye Yellow Brick Road',
        artistName: 'Elton John',
        label: 'Rimas Entertainment',
        releaseDate: '1973',
        image: 'https://images.fineartamerica.com/images/artworkimages/mediumlarge/3/1973-goddbye-yellow-brick-road-album-cover-david-lee-thompson.jpg',
        length: '76',
        price: 15.99,
        trackList: [
            "Funeral for a Friend (Side One)",
            "Love Lies Bleeding (Side One)",
            "Candle in the Wind (Side One)",
            "Bennie and the Jets (Side One)",
            "Goodbye Yellow Brick Road (Side Two)",
            "This Song Has No Title (Side Two)",
            "Grey Seal (Side Two)",
            "Jamaica Jerk Off (Side Two)",
            "I've Seen That Movie Too (Side One)",
            "Sweet Painted Lady (Side One)",
            "The Ballad of Danny Bailey (1909-34) (Side One)",
            "Dirty Little Girl (Side One)",
            "All the Girls Love Alice (Side One)",
            "Your Sister Can't Twist (But She Can Rock'n'roll) (Side Two)",
            "Saturday Night's Alright for Fighting (Side Two)",
            "Roy Rogers (Side Two)",
            "Social Disease (Side Two)",
            "Harmony (Side Two)"
        ]
        
    },
    {
        id: 25,
        title: 'Bury Me At Makeout Creek',
        artistName: 'Mitski',
        label: 'Loma Vista Recordings',
        releaseDate: '2014',
        image: 'https://m.media-amazon.com/images/I/61oLAk3KrcL._UF1000,1000_QL80_.jpg',
        length: '30',
        price: 9.99,
        trackList: [
            "Texas Reznikoff",
            "Townie",
            "First Love / Late Spring",
            "Francis Forever",
            "I Don't Smoke",
            "Jobless Monday",
            "Drunk Walk Home",
            "I Will",
            "Carry Me Out"
        ]
        
    },
    {
        id: 26,
        title: 'Tár',
        artistName: 'Hildur Goðnadottir',
        label: 'Dead Oceans',
        releaseDate: '2022',
        image: 'https://m.media-amazon.com/images/I/615Ja3MlyKL._UF1000,1000_QL80_.jpg',
        length: '64',
        price: 15.99,
        trackList: [
            "For Petra (Vocal)",
            "Mortar",
            "Hildur Guðnadóttir Speaking About the Work 'For Petra' (From the Film Tar)-Introductory Words By Hildur Guðnadóttir",
            "For Petra (Orchestral)",
            "Hildur Guðnadóttir Speaking About the Work 'For Petra' (From the Film Tar)-Hildur's Impressions",
            "Tar-1. Largo",
            "Tar-2. Allegro",
            "Tar-3. Moderato",
            "Symphony No. 5 in C Sharp Minor-Rehearsal: 1. Trauermarsch & 2. Stürmisch Bewegt",
            "Symphony No. 5 in C Sharp Minor-Rehearsal: 4. Adagietto",
            "Recording Session for Elgar's Cello Concerto (For the Film Tar)-Introductory Words",
            "Cello Concerto in E Minor Op. 85-4. Allegro / First Take [Excerpt]",
            "Recording Session for Elgar's Cello Concerto (For the Film Tar)-Control-Room Talk",
            "Cello Concerto in E Minor Op. 85-4. Allegro",
            "Recording Session for Elgar's Cello Concerto (For the Film Tar)-Applause",
            "Cello Concerto in E Minor Op. 85-1. Adagio - Moderato [Excerpt]",
            "Here's That Rainy Day",
            "Dialogue from the Film Tar-Lesson - Prelude in C Major, BWV 846 (From the Well-Tempered Clavier, Book I [Excerpt])",
            "Dialogue from the Film Tar-Lydia Tar Field Recording",
            "Cura Mente"
        ]
        
    },
    {
        id: 27,
        title: 'Magdelene',
        artistName: 'FKA Twigs (Tahlia Barnett)',
        label: 'Focus Features LLC',
        releaseDate: '2019',
        image: 'https://media.pitchfork.com/photos/645e698710ea75c3530616af/master/w_1280%2Cc_limit/FKA-Twigs-Magdalene.jpg',
        length: '39',
        price: 9.99,
        trackList: [
            "Thousand Eyes",
            "Home With You",
            "Sad Day",
            "Holy Terrain (feat. Future)",
            "Mary Magdalene",
            "Fallen Alien",
            "Mirrored Heart",
            "Daybed"
          ]

    },
    {
        id: 28,
        title: 'Glassworks & Interview with Philip Glass',
        artistName: 'Philip Glass',
        label: 'Secretly Canadian',
        releaseDate: '2016',
        image: 'https://i.discogs.com/ci2rpiKcN0Ril-WTb91kYICCZ5L3qn74XFNwZiOBihI/rs:fit/g:sm/q:90/h:574/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNzY3/ODAtMTI3NTYxOTEz/Mi5qcGVn.jpeg',
        length: '88',
        price: 15.99,
        trackList: [
            "Opening",
            "Floe",
            "Islands",
            "Rubric",
            "Facades",
            "Closing",
            "Interview with Philip Glass"
          ]
          
    },
    {
        id: 29,
        title: 'Tonya Harding',
        artistName: 'Sufjan Stevens',
        label: 'Young (FKA Young Turks)',
        releaseDate: '2017',
        image: 'https://media.pitchfork.com/photos/5a318075e807ee3420166365/master/pass/tonya%20harding.jpg',
        length: '9',
        price: 5.99,
        trackList: [
            "Tonya Harding (In D Major)",
            "Tonya Harding (In Eb Major)",
            "Tonya Harding (In Ab Major)",
            "Tonya Harding (In B Major)"
          ]
          
    },
    {
        id: 30,
        title: '21',
        artistName: 'Adele',
        label: 'XL Recordings LC',
        releaseDate: '2011',
        image: 'https://m.media-amazon.com/images/I/61lMwNQGYbL._UF1000,1000_QL80_.jpg',
        length:'52',
        price: 10.99,
        trackList: [
            "Rolling in the Deep",
            "Rumour Has It",
            "Turning Tables",
            "Don't You Remember",
            "Set Fire to the Rain",
            "He Won't Go",
            "Take It All",
            "I'll Be Waiting",
            "One and Only",
            "Lovesong",
            "Someone Like You"
        ]
    },
    {
        id: 31,
        title: '\"Awaken, My Love!\"',
        artistName: 'Childish Gambino (Donald Glover)',
        label: 'XL Recordings LC',
        releaseDate: '2016',
        image: 'https://media.pitchfork.com/photos/65772273239ec61ed8f07f5c/master/w_1280%2Cc_limit/Childish-Gambino-Awaken-My-Love.jpg',
        length: '49',
        price: 9.99,
        trackList: [
            "Me and Your Mama",
            "Have Some Love",
            "Boogieman",
            "Zombies",
            "Riot",
            "Redbone",
            "California",
            "Terrified",
            "Baby Boy",
            "The Night Me and Your Mama Met",
            "Stand Tall"
        ]
    },
    {
        id: 32,
        title: 'Punisher',
        artistName: 'Phoebe Bridges',
        label: 'Loma Vista Recordings',
        releaseDate: '2020',
        image: 'https://media.pitchfork.com/photos/5e8f1c49ecfafc0008428b37/master/pass/Phoebe-Bridgers-Punisher.jpg',
        length: '41',
        price: 7.99,
        trackList: [
            "DVD Menu",
            "Garden Song",
            "Kyoto",
            "Punisher",
            "Halloween",
            "Chinese Satellite",
            "Moon Song",
            "Savior Complex",
            "ICU",
            "Graceland Too",
            "I Know the End"
        ]
        
    },
    {
        id: 33,
        title: 'The Dune SketchBook',
        artistName: 'Hans Zimmer',
        label: 'McDJ Entertainment',
        releaseDate: '2021',
        image: 'https://m.media-amazon.com/images/I/91B637EHz6L._UF1000,1000_QL80_.jpg',
        length: '102',
        price: 15.99,
        trackList: [
            "Paul's Dream (Dune Sketchbook Version)",
            "Riding the Sandworm (Dune Sketchbook Version)",
            "Ripples in the Sand (Dune Sketchbook Version)",
            "The Reverend Mother (Dune Sketchbook Version)",
            "The Gom Jabbar (Dune Sketchbook Version)",
            "House Atreides (Dune Sketchbook Version)",
            "Dark Reflections (Dune Sketchbook Version)",
            "Bene Gesserit Ritual (Dune Sketchbook Version)",
            "Guild Navigator (Dune Sketchbook Version)",
            "Sandworms (Dune Sketchbook Version)",
            "The Spice (Dune Sketchbook Version)",
            "Paul Meets Chani (Dune Sketchbook Version)"
        ]
        
    },
    {
        id: 34,
        title: 'Shabrang',
        artistName: 'Sevdaliza',
        label: 'Debay Sounds LLC',
        releaseDate: '2020',
        image: 'https://media.pitchfork.com/photos/5f46748da3044e1e655f14a4/master/pass/shabrang_sevdalia.jpg',
        length: '62',
        price: 9.99,
        trackList: [
            "Joanna",
            "Lamp Lady",
            "All Rivers at Once",
            "Habibi",
            "Wallflower",
            "Gole Bi Goldoon",
            "Human Nature",
            "No Way",
            "Oh My God",
            "Eden"
        ]
        
    },
    {
        id: 35,
        title: 'Græ',
        artistName: 'Moses Sumney',
        label: 'WaterTower Music',
        releaseDate: '2020',
        image: 'https://media.pitchfork.com/photos/5eb98004a994f4606de32768/1:1/w_800,h_800,c_limit/græ%20(Part%20Two-%2013%20Two%20Dogs)_Moses%20Sumney.jpg',
        length: '66',
        price: 7.99,
        trackList: [
            "Insula",
            "Cut Me",
            "In Bloom",
            "Virile",
            "Conveyor",
            "boxes",
            "Gagarin",
            "jill/jack",
            "Colouour",
            "also also also and and and",
            "Neither/Nor",
            "Polly",
            "Two Dogs",
            "Bystanders",
            "Me in 20 Years",
            "Keeps Me Alive",
            "Lucky Me",
            "and so I come to isolation"
        ]
        
    },
    {
        id: 36,
        title: 'Again',
        artistName: 'Oneohtrix Point Never (Daniel Lopatin)',
        label: 'Twisted Elegance',
        releaseDate: '2023',
        image: 'https://media.pitchfork.com/photos/64e567827a86d58a09b09f21/master/w_1280%2Cc_limit/oneohtrix-point-never-again.jpg',
        length: '57',
        price: 7.99,
        trackList: [
            "Age Of",
            "Babylon",
            "Manifold",
            "The Station",
            "Toys 2",
            "Black Snow",
            "Myriad.Industries",
            "Warning",
            "We'll Take It",
            "Same",
            "RayCats",
            "Still Stuff That Doesn't Happen",
            "Last Known Image of a Song (Ryuichi Sakamoto Rework)"
        ]
    },
    {
        id: 37,
        title: 'Selected Ambient Works 85-92',
        artistName: 'Aphex Twin',
        label: 'JagJaguwar',
        releaseDate: '1971',
        image: 'https://f4.bcbits.com/img/0032727004_10.jpg',
        length: '75',
        price: 9.99,
        trackList: [
            "Xtal",
            "Tha",
            "Pulsewidth",
            "Ageispolis",
            "i",
            "Green Calx",
            "Heliosphan",
            "We Are the Music Makers",
            "Schottkey 7th Path",
            "Ptolemy",
            "Hedphelym",
            "Delphium",
            "Actium"
        ]
    },
    {
        id: 38,
        title: 'Surrender',
        artistName: 'Maggie Rogers',
        label: 'R&S Records',
        releaseDate: '2022',
        image: 'https://media.pitchfork.com/photos/624471872afbc1aa4dab0c4c/master/pass/Maggie-Rogers-Surrender.jpg',
        length: '46',
        price: '7.99',
        trackList: [
            'Overdrive',
            'Thats where I am',
            'Want Want',
            'Anywhere With You',
            'Horses',
            'Be Cool',
            'Shatter',
            'Begging for Rain',
            'Ive got a friend',
            'Honey',
            'Symphony',
            'Different Kind of World'
        ]
    },
    {
        id: 39,
        title: 'Phoenix: Flames are Dew Upon My Skin',
        artistName: 'Eartheater',
        label: 'Debay Sounds LLC',
        releaseDate: '2020',
        image: 'https://media.pitchfork.com/photos/5f721a37b721798c1a9de152/1:1/w_3000,h_3000,c_limit/Pheonix-%20Flames%20Are%20Dew%20Upon%20My%20Skin_eartheater.jpg',
        length: '47',
        price: '7.99',
        trackList: [
            'Airborne Ashes',
            'Metallic Taste of Patience',
            'Below the Clavicle',
            'Burning Feather',
            'How To Fight',
            'Kiss of the Phoenix',
            'Volcano',
            'Fantasy Collision',
            'Mercurial Nerve',
            'Goodbye Diamond',
            'Bringing Me Back',
            'Diamond in the Bedrock',
            'Faith Consuming Hope',

        ]
    }
];

export default {
    getAlbumData() {
        return albums;
    },
    getTracks(albumId) {
        const album = albums.find(album => album.id === albumId);
        return album ? album.trackList : [];
    },

};

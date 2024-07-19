import React, {useEffect, useState} from "react";
import axios from "axios";
import '../Styles/Organizers.css'


function Organizers() {
    const [organizers, setOrganizers] = useState([]);
    const [filterOrganizers, setFilteredOrganizers] = useState([]);
    const [searchName, setSearchName] = useState('')

    useEffect(() => {
        const fetchOrganizations = async () => {
            try {
                const response = await axios.get('http://localhost:3000/organizers');
                setOrganizers(response.data)
                setFilteredOrganizers(response.data)
                console.log(response.data)
            } catch (error) {
                console.error('Error fetching organizations:', error);
            }
        };

        fetchOrganizations().then()
    }, []);

    useEffect(() => {
        if(organizers){
            const filtered = organizers.filter( organization =>
                organization['Organizer Name'].toLowerCase().includes(searchName.toLowerCase())
            );
            setFilteredOrganizers(filtered)
        } else {
            setFilteredOrganizers(organizers);
        }
    }, [searchName, organizers]);

    const handleSearchChange = (event) => {
        setSearchName(event.target.value);
    }

    return (
        <>
            <section className="organizers-page">
                <h1 className="organizers-title">Organizers</h1>
                <section className="search-container">
                    <input
                        type="text"
                        className="search"
                        placeholder="Search Organizers"
                        value={searchName}
                        onChange={handleSearchChange}
                    />
                </section>
                <section className="organizers-list">
                    {filterOrganizers.map(organizer => (
                        <section key={organizer['Id']} className="organizer-item">
                            <img alt="" src="" className="organizer-image"/>
                            <h2 className="organizer-name">{organizer['Organizer Name']}</h2>
                            <blockquote className="organizer-bio">{organizer['Organizer Bio']}</blockquote>
                        </section>
                    ))}

                </section>
            </section>
        </>
    )
}


export default Organizers
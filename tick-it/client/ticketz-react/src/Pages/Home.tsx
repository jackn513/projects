import React, { useEffect, useState } from "react";
import '../Styles/Home.css';
import axios from "axios";
import eventpng from '../../../react-ticketz/src/assets/event.png'
function Home() {
    const [events, setEvents] = useState([]);

    // Fetch events when the component mounts
    useEffect(() => {
        const fetchEvents = async () => {
            try {
                const response = await axios.get('http://localhost:3000/events');
                const allEvents = response.data;

                // Shuffle the events and take the first 5
                const shuffledEvents = allEvents.sort(() => 0.4 - Math.random());
                const randomEvents = shuffledEvents.slice(0, 4);

                setEvents(randomEvents);
                console.log(randomEvents);  // Log only the 5 random events
            } catch (error) {
                console.error('Error fetching events:', error);
            }
        };

        fetchEvents();
    }, []);

    return (
        <>
            <section className="home-page">
                <h1 className="home-title">Ticketz</h1>
                <blockquote>
                    <p>Hello, welcome to Ticketz. Here are 5 randomly selected upcoming events:</p>
                </blockquote>
                <section className="events-list">
                    {events.length > 0 ? (
                        events.map(events => (
                            <div key={events['Event Id']} className="event-item">
                                <img alt="" src=""  className="event-image" />
                                <h2 className="event-name">{events['Event Name']}</h2>
                                <h3 className="organizer-name">{events['Organizers']['Organizer Name']}</h3>
                                <p className="event-description">{events['Event Description']}</p>
                                <p className="event-date">{events['Date']}</p>
                                <p className="event-time">{events['Time of Event']}</p>
                                <p className="event-location">{events['Location']}</p>
                                {events['Status'] !== 'cancel' && events['Status'] !== 'ended' && (
                                    <>
                                        <p className="event-status">{events['Status']}</p>
                                        <button className="add">Add to my events</button>
                                    </>
                                )}
                                <p className="event-price">Price TBD</p>
                            </div>
                        ))
                    ) : (
                        <p>No events available.</p>
                    )}
                </section>

            </section>
        </>
    );
}

export default Home;

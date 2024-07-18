import React from "react";
import './App.css'
import NavBar from "./NavBar/nav-bar.tsx";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Events from "./Events/Events.tsx";
import Profile from "./Profile/Profile.tsx";
import Create from "./Create/Create.tsx";
import Login from "./Login/Login.tsx";
import Home from "./Home/Home.tsx";
import Organizers from "./Organizers/Organizers.tsx";
import OrganizerDetail from "./Organizers/OrganizerDetail.tsx";

function App() {

    return (
        <>
            <div className={"app-page"}>

                <Router>
                    <NavBar />
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/events" element={<Events />} />
                        <Route path="/organizers" element={<Organizers/>}/>
                        <Route path="/organizers/:id" element={<OrganizerDetail />} />
                        <Route path="/profile" element={<Profile />} />
                        <Route path="/create" element={<Create />} />
                        <Route path="/login" element={<Login />} />
                    </Routes>
                </Router>
            </div>

        </>
    )
}

export default App

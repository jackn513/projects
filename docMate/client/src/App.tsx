import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import { useState } from 'react';
import Register from './views/register.tsx'; // Ensure this path and file are correct
import NavBar from './components/nav-bar.tsx';
import Login from './views/login.tsx';

function App() {
    // Simulated authentication state
    const [isLoggedIn, setIsLoggedIn] = useState(false); // Replace with actual authentication logic

    return (
        <>
            <section className="app-page">
                <Router>
                    <NavBar />
                    <Routes>
                        <Route
                            path="/"
                            element={isLoggedIn ? <Home /> : <Navigate to="/login" />}
                        />
                        <Route path="/register" element={<Register />} />
                        <Route path="/login" element={<Login setIsLoggedIn={setIsLoggedIn} />} />
                    </Routes>
                </Router>
            </section>
        </>
    );
}

function Home() {
    return (
        <section className="home">
            <h2>Home Page</h2>
            <p>Welcome to the DocMate home page!</p>
        </section>
    );
}

export default App;

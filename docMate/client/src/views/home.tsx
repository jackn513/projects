import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import '../styles/home.css';

function Home() {
    const [docs, setDocs] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchDocs = async () => {
            const token = localStorage.getItem("token");

            // If there's no token, redirect to login
            if (!token) {
                navigate("/login");
                return;
            }

            try {
                const response = await axios.get("http://localhost:3000/documents/my-documents", {
                    headers: { Authorization: `Bearer ${token}` },
                });

                setDocs(response.data);
                console.log(response.data);
            } catch (error) {
                console.error("Error fetching the docs", error);
            }
        };

        fetchDocs();
    }, [navigate]); // Include navigate in the dependency array

    return (
        <section className="home">
            <h1 className="my-docmate-title">My docMate</h1>
            <section className="docs-list">
                {docs.length === 0 ? (
                    <p>No documents available.</p>
                ) : (
                    docs.map((doc) => (
                        <div className="doc-item" key={doc['Document Id']}>
                            <img alt={"IMAGE"} className="doc-preview"></img>
                            <h2 className="doc-title">{doc['Title'].split(" ")[0]}...</h2>
                        </div>
                    ))
                )}
            </section>
        </section>
    );
}

export default Home;

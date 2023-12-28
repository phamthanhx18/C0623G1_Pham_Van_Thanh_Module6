import React, {useEffect, useState} from 'react';
import Header from "../components/Header";
import Footer from "../components/Footer";
import axios from "axios";

function TopPhat() {
    const [topStudent, setTopStudent] = useState([]);
    const getTopPhat = async () => {
      let res = await axios.get("http://localhost:8080/api/top/phat");
      setTopStudent(res.data)
    }
    useEffect(() => {
        getTopPhat();
    }, []);

    function formatDateTime(dateTime) {
        let formattedDate = new Date(dateTime);
        let year = formattedDate.getFullYear();
        let month = (formattedDate.getMonth() + 1).toString().padStart(2, "0");
        let day = formattedDate.getDate().toString().padStart(2, "0");
        return `${day}/${month}/${year} `;
    }
    return (
        <>
            <Header/>
            <div className="container">
                <h2>Top 5 học viên bị phạt !</h2>
                <table className="table table-hover text-center border mt-3">
                    <thead className="table-secondary">
                    <tr>
                        <th>STT</th>
                        <th>Tên học viên</th>
                        <th>Ngày sinh</th>
                        <th>Email</th>
                        <th>CCCD</th>
                        <th>Tên lớp</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {topStudent.length === 0 ? (
                        <tr>
                            <td colSpan={100}>Không có dữ liệu</td>
                        </tr>
                    ) : (
                        topStudent.map((item, index) => (
                            <tr key={item.idStudent}>
                                <td>{index + 1}</td>
                                <td>{item.nameStudent}</td>
                                <td>{formatDateTime(item.birthday)}</td>
                                <td>{item.email}</td>
                                <td>{item.idCard}</td>
                                <td>{item.classRoom.nameClass}</td>
                            </tr>
                        ))
                    )}
                    </tbody>
                </table>
            </div>
            <Footer/>
        </>
    );
}

export default TopPhat;
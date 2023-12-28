import React, {useEffect, useState} from 'react';
import Header from "../components/Header";
import Footer from "../components/Footer";
import axios from "axios";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {toast} from "react-toastify";
import {Link} from "react-router-dom";
import {Modal} from "react-bootstrap";
import Pagination from "../components/pagination/Pagination";

function HomePage() {
    const [students, setStudents] = useState([]);
    const [studentViewModal, setStudentViewModal] = useState({});
    const [listThuongPhat, setListThuongPhat] = useState([]);
    const [show, setShow] = useState(false);
    const [totalPage, setTotalPage] = useState(0);
    const [currentPage, setCurrentPage] = useState(0);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);
    const getAllStudent = async () => {
        let res = await axios.get(`http://localhost:8080/api/students?page=${currentPage}`);
        setStudents(res.data.content);
        setTotalPage(res.data.totalPages);
        setCurrentPage(res.data.number)
    }

    useEffect(() => {
        getAllStudent();
    }, [currentPage]);
    const handelSubmitFormSearch = async (values) => {
        try {
            let res = await axios.get(`http://localhost:8080/api/students/getByClass?className=${values.className}`);
            if (res.status === 200) {
                setStudents(res.data.content);
                setTotalPage(res.data.totalPages);
                setCurrentPage(res.data.number)
            } else if (res.status === 204) {
                toast.error("Không có học viên nào đang theo học lớp này !")
            }
        } catch (e) {
            toast.error("Lớp này không tồn tại !")
        }
    };

    const handleViewThuongPhat = async (item) => {
        setStudentViewModal(item);
        try {
            let res = await axios.get(`http://localhost:8080/api/hinh-thuc/${item.idStudent}`)
            setListThuongPhat(res.data);
        } catch (e) {
            console.log(e)
        }
        handleShow();
    };

    const hoanThanhThuongPhat = async () => {
        try {
            await axios.patch(`http://localhost:8080/api/hinh-thuc/${studentViewModal.idStudent}`)
            toast.success("Thành công !");
            handleViewThuongPhat(studentViewModal);
        } catch (e) {
            toast.error("Đã có lỗi xảy ra");
        }
    };

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber);
    };

    function formatDateTime(dateTime) {
        let formattedDate = new Date(dateTime);
        let year = formattedDate.getFullYear();
        let month = (formattedDate.getMonth() + 1).toString().padStart(2, "0");
        let day = formattedDate.getDate().toString().padStart(2, "0");
        return `${day}/${month}/${year} `;
    }

    const resetTable = () => {
        setCurrentPage(0)
        getAllStudent();
    };
    return (
        <>
            <Header/>
            <div className="container" style={{minHeight: "90vh"}}>
                <h3>Danh sách học viên </h3>
                <Formik initialValues={{className: ""}} onSubmit={(values) => handelSubmitFormSearch(values)}>
                    <Form>
                        <div className="row align-items-end">
                            <div className="col-lg-auto">
                                <div className="mb-3">
                                    <label htmlFor="className" className="form-label">Tìm học viên theo lớp</label>
                                    <Field type="text" className="form-control" name="className" id="className"/>
                                    <ErrorMessage name="className" className="text-danger" component="p"/>
                                </div>
                            </div>
                            <div className="col-auto">
                                <div className="mb-3">
                                    <button type="submit" className="btn btn-primary">Tìm kiếm</button>
                                </div>
                            </div>

                        </div>
                    </Form>
                </Formik>
                <div className="col-auto">
                    <div className="mb-3">
                        <button onClick={resetTable} className="btn btn-primary">Đặt lại</button>
                    </div>
                </div>
                <div className="row mb-3">
                    <div className="col-auto">
                        <Link to="/top-phat" className="btn btn-warning">TOP bị phạt</Link>
                    </div>
                    <div className="col-auto">
                        <Link to="/list-chua-thuong" className="btn btn-warning">Chưa từng được thưởng</Link>
                    </div>
                    <div className="col-auto">
                        <Link to="/create-student" className="btn btn-warning">Thêm mới học viên</Link>
                    </div>
                </div>
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
                    {students.length === 0 ? (
                        <tr>
                            <td colSpan={100}>Không có dữ liệu</td>
                        </tr>
                    ) : (
                        students.map((item, index) => (
                            <tr key={item.idStudent}>
                                <td>{index + 1}</td>
                                <td>{item.nameStudent}</td>
                                <td>{formatDateTime(item.birthday)}</td>
                                <td>{item.email}</td>
                                <td>{item.idCard}</td>
                                <td>{item.classRoom.nameClass}</td>
                                <td>
                                    <button className="btn btn-primary" onClick={() => handleViewThuongPhat(item)}>Xem
                                        thưởng phạt
                                    </button>
                                </td>
                            </tr>
                        ))
                    )}
                    </tbody>
                </table>
                <div className="my-3">
                    <Pagination totalPages={totalPage} page={currentPage} onPageChange={handlePageChange}/>
                </div>
            </div>
            <Modal
                id="modalLogin"
                show={show} onHide={handleClose}
                size="lg"
                aria-labelledby="contained-modal-title-vcenter"
                centered
            >
                <Modal.Body>
                    <Modal.Header className="modal-login" closeButton/>
                    <h4>Danh sách thưởng phạt của {studentViewModal.nameStudent}</h4>
                    <button onClick={hoanThanhThuongPhat} className="btn btn-success">Hoàn thành</button>
                    <table className="table table-hover text-center border mt-3">
                        <thead className="table-secondary">
                        <tr>
                            <th>STT</th>
                            <th>Tên học viên</th>
                            <th>Ngày ghi</th>
                            <th>Thưởng/Phạt</th>
                            <th>Nội dung</th>
                            <th>Trạng thái</th>
                        </tr>
                        </thead>
                        <tbody>
                        {listThuongPhat.length === 0 ? (
                            <tr>
                                <td colSpan={100}>Không có dữ liệu</td>
                            </tr>
                        ) : (
                            listThuongPhat.map((item, index) => (
                                <tr key={item.id}>
                                    <td>{index + 1}</td>
                                    <td>{item.student.nameStudent}</td>
                                    <td>{formatDateTime(item.dateCreate)}</td>
                                    <td>{item.typeBonus.nameBonus}</td>
                                    <td>{item.note}</td>
                                    <td>{item.status.nameStatus}</td>
                                </tr>
                            ))
                        )}
                        </tbody>
                    </table>
                </Modal.Body>
            </Modal>
            <Footer/>
        </>
    );
}

export default HomePage;
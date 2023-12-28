import React, {useEffect, useState} from 'react';
import Header from "../components/Header";
import Footer from "../components/Footer";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import axios from "axios";
import {toast} from "react-toastify";

function CreateStudent() {
    const [classRoom, setClassRoom] = useState([])
    const getAllClassRoom = async () => {
        let res = await axios.get("http://localhost:8080/api/classRoom");
        setClassRoom(res.data);
    }
    useEffect(() => {
        getAllClassRoom();
    }, []);
    const initValues = {
        nameStudent: "",
        birthday: "",
        email: "",
        phone: "",
        idCard: "",
        classId: 1
    }

    const validationSchema = Yup.object({
        nameStudent: Yup.string()
            .required('Vui lòng nhập tên.')
            .min(2, 'Tên phải có ít nhất 2 ký tự.')
            .max(50, 'Tên không được quá 50 ký tự.')
            .matches("^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+( ([AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ]|[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz])[aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+)+$", "Tên không đúng định dạng. Ex(Phạm Văn Thành)"),
        idCard: Yup.string().required("Vui lòng nhập CMND")
            .max(12,"Không quá 12 kí tự"),
        birthday: Yup.date()
            .required('Vui lòng nhập ngày sinh.')
            .max(new Date(), 'Ngày sinh không được lớn hơn ngày hiện tại.')
            .test(
                'is-18-or-older',
                'Bạn phải ít nhất 18 tuổi.',
                value => {
                    const today = new Date();
                    const birthDate = new Date(value);
                    let age = today.getFullYear() - birthDate.getFullYear();
                    const m = today.getMonth() - birthDate.getMonth();
                    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
                        age--;
                    }
                    return age >= 18 && age <= 80;
                }
            ),

        phone: Yup.string()
            .required('Vui lòng nhập số điện thoại.')
            .matches(/^\+\(84\)[0-9]{9}$/, 'Số điện thoại phải đúng định dạng +(84)...'),
        email: Yup.string()
            .email('Email không hợp lệ.')
            .required('Vui lòng nhập email.')
    });
    const handleSubmitForm = async (values,{setFieldError}) => {
        try {
            await axios.post("http://localhost:8080/api/students",values)
            toast.success("Thêm mới thành công !")
        } catch (e) {
            setFieldError("email",e.response.data);
        }
    };
    return (
        <>
            <Header/>
            <div className="container">
                <h3>Thêm mới học viên</h3>
                <Formik
                    initialValues={initValues}
                    onSubmit={(values,{setFieldError}) => handleSubmitForm(values,{setFieldError})}
                    validationSchema={validationSchema}
                >
                        <Form>
                            <div className="row">
                                <div className="col-lg-12 col-sm-12">
                                    <div className="content-information">
                                        <div>
                                            <div className="mb-3">
                                                <label htmlFor="name" className="form-label">Tên học
                                                    viên</label>
                                                <Field name="nameStudent" type="text" className="form-control"
                                                       id="name"/>
                                                <ErrorMessage name="nameStudent" className="text-danger"
                                                              component="small"/>
                                            </div>
                                            <div className="mb-3">
                                                <label htmlFor="birthday" className="form-label">Ngày
                                                    sinh</label>
                                                <Field type="date" className="form-control"
                                                       name="birthday"/>
                                                <ErrorMessage name="birthday" className="text-danger"
                                                              component="small"/>
                                            </div>
                                            <div className="mb-3">
                                                <label htmlFor="phone" className="form-label">Số điện
                                                    thoại</label>
                                                <Field type="text" className="form-control"
                                                       name="phone"/>
                                                <ErrorMessage name="phone" className="text-danger"
                                                              component="small"/>
                                            </div>
                                            <div className="mb-3">
                                                <label htmlFor="idCard" className="form-label">CMND/CCCD</label>
                                                <Field type="text" className="form-control"
                                                       name="idCard"/>
                                                <ErrorMessage name="idCard" className="text-danger"
                                                              component="small"/>
                                            </div>
                                            <div className="mb-3">
                                                <label htmlFor="phone" className="form-label">Địa chỉ email</label>
                                                <Field type="email" className="form-control" name="email"/>
                                                <ErrorMessage name="email" className="text-danger"
                                                              component="small"/>
                                            </div>

                                            <div className="mb-3">
                                                <label htmlFor="phone" className="form-label">Địa chỉ email</label>
                                                <Field as="select" className="form-select" name="classId">
                                                    {classRoom.map((item) => (
                                                        <option key={item.idClass} value={item.idClass}>{item.nameClass}</option>
                                                    ))}
                                                </Field>
                                            </div>
                                            <div className="text-center">
                                                <button type="submit" className="btn btn-primary mb-3">Thêm mới
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </Form>
                </Formik>
            </div>
            <Footer/>
        </>
    );
}

export default CreateStudent;
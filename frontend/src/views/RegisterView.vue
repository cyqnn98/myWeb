<template>
    <div>
        <el-space wrap>
            <el-card class="box-card" style="width: 800px">
                <template #header>
                    <div class="card-header">
                        <span>New User Registration</span>
                    </div>
                </template>
                <el-form :model="form" label-width="120px">
                    <el-form-item label="Name">
                        <el-col :span="20">
                            <el-input v-model="form.name" />
                        </el-col>
                        <el-col :span="1"/>
                    </el-form-item>
                    <el-form-item label="Phone Number">
                        <el-col :span="20">
                            <el-input v-model="form.phoneNum"/>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="Email">
                        <el-col :span="20">
                            <el-input v-model="form.email"/>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="password">
                        <el-col :span="20">
                            <el-input v-model="form.password"/>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="Date of Birth">
                        <el-col :span="20">
                            <el-date-picker v-model="form.dateOfBirth" type="date" placeholder="Pick a date" style="width: 100%" />
                        </el-col>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm">Submit</el-button>
                        <el-button>Cancel</el-button>
                        <div>
                        <div class="registerText">
                            Already have an account? Click
                            <RouterLink to="/login">
                                <el-link type="primary">here</el-link>
                            </RouterLink>
                            to login.
                        </div>
                    </div>
                    </el-form-item>
                </el-form>
            </el-card>
        </el-space>
    
    </div>
    </template>
    
    <script>
    export default {
        data() {
            return {
                form: {
                    name: "",
                    dateOfBirth: "",
                    phoneNum:"",
                    email:"",
                    password:"",
                }
            }
        },
        methods: {
            submitForm() {
                console.log(this.form.dateOfBirth)
            }
        },
        mounted() {
            // this.getProducts();
        }
    }
    </script>
    
    <style>
    .formPosition {
        margin-top: 100px;
    }
    </style>
    
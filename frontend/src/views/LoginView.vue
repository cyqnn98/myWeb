<template>
<div>
    <el-space wrap>
        <el-card class="box-card" style="width: 800px">
            <template #header>
                <div class="card-header">
                    <span>User Login</span>
                </div>
            </template>
            <el-form :model="form" label-width="120px">
                <el-form-item label="Email">
                    <el-col :span="20">
                        <el-input v-model="userForm.email" />
                    </el-col>
                </el-form-item>
                <el-form-item label="password">
                    <el-col :span="20">
                        <el-input v-model="userForm.password" />
                    </el-col>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="confirm">Confirm</el-button>
                    <el-button>Cancel</el-button>
                    <div>
                        <div class="registerText">
                            New user? Click
                            <RouterLink to="/register">
                                <el-link type="primary">here</el-link>
                            </RouterLink>
                            to register.
                        </div>
                    </div>
                </el-form-item>
            </el-form>
        </el-card>
    </el-space>

</div>
</template>

<script>
import UserService from '@/services/UserService'

export default {
    data() {
        return {
            userForm: {
                email: "",
                password: "",
            }

        }
    },
    methods: {
        confirm() {
            UserService.login(this.userForm)
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
.registerText{
    margin-left: 30px;
}
</style>

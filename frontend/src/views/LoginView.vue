<template>
     <page-header class="headerBottom"></page-header>
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
                        <!-- <div>
                            {{ getToken }}
                        </div> -->
                    </div>
                </el-form-item>
            </el-form>
        </el-card>
    </el-space>

</div>
</template>

<script>
import PageHeader from '@/components/Header.vue'
import UserService from '@/services/UserService'

export default {
    components:{
        PageHeader
    },
    data() {
        return {
            userForm: {
                email: "",
                password: "",
            },
            jwtToken: ""
        }
    },
    methods: {
        confirm() {
            UserService.login(this.userForm)
                .then((response) => {
                    console.log("in login response");
                    console.log(response.data.data.token);
                    this.jwtToken = response.data.data.token;
                    // console.log(this.jwtToken);
                    if (response.data.code === 20000) {
                        console.log('in response data')
                        localStorage.setExpire("token", this.jwtToken, 1000 * 60 * 3); //3 min
                        alert("login success")
                        this.$store.commit('setToken', this.jwtToken)
                        console.log("after commit")
                        console.log(this.$store.state.token)
                        this.$router.push("/userInfo")
                    }
                })
                .catch((error) => {
                    throw error;
                });
        },
        mounted() {
            // this.getProducts();
            console.log("in login view mounted")
            console.log()
        }
    },
    computed: {
        getToken() {
            return this.$store.state.token
        }
    }
}
</script>

<style>
.formPosition {
    margin-top: 100px;
}

.registerText {
    margin-left: 30px;
}
</style>

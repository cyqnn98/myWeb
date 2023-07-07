<template>
<el-descriptions title="User Info">
    <el-descriptions-item label="Username">{{userInfo.userName}}</el-descriptions-item>
    <el-descriptions-item label="Telephone">{{userInfo.phoneNumber}}</el-descriptions-item>
    <el-descriptions-item label="Email">{{userInfo.email}}</el-descriptions-item>
    <el-descriptions-item label="dateOfBirth">
        <el-tag size="small">{{userInfo.dateOfBirth}}</el-tag>
    </el-descriptions-item>
    <!-- <el-descriptions-item label="Address">No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu
        Province</el-descriptions-item> -->
</el-descriptions>
</template>

<script>
import UserService from '@/services/UserService'

export default{
    data(){
        return{
            userInfo: {
                userName:"",
                phoneNumber: "",
                email:"",
                dateOfBirth:""
            }
        }
    },
    mounted(){
        let tokenStored = localStorage.getExpire("token")
        if(tokenStored === null){
            console.log("tokenStored is null")
        }else{
            this.getUserInfo(tokenStored)
        }
    },
    methods: {
        getUserInfo(token){
            UserService.getUserInfo(token)
            .then((response) => {
                if (response.data.code === 20000) {
                        console.log('in getUserInfo response data')
                        let curUserInfo = response.data.data.userInfo
                        this.userInfo.userName = curUserInfo.name
                        this.userInfo.phoneNumber = curUserInfo.phoneNum
                        this.userInfo.email = curUserInfo.email
                        this.userInfo.dateOfBirth = curUserInfo.dateOfBirth
                    }
            })
            .catch((error) => {
                throw error
            })
        }
    }
}
</script>

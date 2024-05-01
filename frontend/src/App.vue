<template>
    <v-app>
        <v-app-bar 
                app 
                clipped-left 
                flat
                color="primary"
        >
            <v-toolbar-title>
                <span class="second-word font uppercase"
                    style="font-weight:700;"
                >
                    <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                    >
                        <div style="line-height:100%;">≡</div>
                    </v-app-bar-nav-icon>
                </span>
            </v-toolbar-title>

            <v-btn icon to="/">
                <v-icon>mdi-home</v-icon>
            </v-btn>
            
            <v-spacer></v-spacer>

        </v-app-bar>

        <v-navigation-drawer 
                v-model="sideBar"
                app 
                clipped 
                flat 
        >
            <v-list>
                <v-list-item
                        class="px-2"
                        key="coefficients"
                        to="/meterings/coefficients"
                        color="primary"
                        style="font-weight:700;"
                >
                    계수
                </v-list-item>

            </v-list>
        </v-navigation-drawer>

        <v-main>
            <router-view></router-view>
        </v-main>
    </v-app>
</template>

<script>
    export default {
        name: "App",
        data: () => ({
            sideBar: true,
        }),
        created() {
            const el = document.createElement('div');
            el.setAttribute('data-app', true);
            document.body.appendChild(el);
        
        },
        methods: {
            openSideBar(){
                this.sideBar = !this.sideBar
            },
        },
    };
</script>

<style>
</style>

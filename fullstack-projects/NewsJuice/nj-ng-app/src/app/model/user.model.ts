import { MatPaginatedTabHeader } from "@angular/material/tabs/paginated-tab-header";

export class UserModel {

    userId!: number;
    userName!: string;
    userMail!: string;
    age!: number;

    subscriptions!: any[];
    userSetting!: Map<string, string>;


    constructor() {
        this.userId = 0;
        this.userName = "";
        this.userMail = "";
        this.age = 0;
        this.subscriptions = [];
        this.userSetting = new Map();
    }
}

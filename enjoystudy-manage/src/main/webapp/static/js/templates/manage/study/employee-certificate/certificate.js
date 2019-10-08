function Certificate() {};

Certificate.prototype = {
    id: "",
    employeeId: "",
    employeeName: "",
    employeeSex: "",
    employeeBorn: "",
    identityType: "",
    identityCode: "",
    certificateId: "",
    certificateCode: "",
    chineseCertificateName: "",
    englishCertificateName: "",
    certificateDate: "",
    certificateState: "",
    chineseContent: "",
    englishContent: "",
    sealPhoto: "",
    organizationCode: "",
    chineseOrganizationName: "",
    englishOrganizationName: "",
    teacherId: "",
    chineseTeacherName: "",
    englishTeacherName: "",
    certificateState: ""
};

function certificateState(state) {
    var val;
    switch (state) {
        case 1:
            val = "正常";
            break;
        case 2:
            val = "过期";
            break;
        case 3:
            val = "作废";
            break;
        default:
            val = "";
    }
    return val;
}


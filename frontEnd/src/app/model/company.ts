export interface Company {
    id:string;
    companyName:string;
    stockCode:string;
    turnover:string;
    ceo:string;
    //ipoDate:string;
    exchangeName:string;
    briefIntro:string;
    sectorsBySectorsId:{
        id:string;
        sectorName:string;
    }
}

import convertTime from "./time.js";
 

test("convert millseconds",()=>{
    expect(convertTime(10000)).toEqual("10 Seconds")
});
test("convert millseconds",()=>{
    expect(convertTime(60000)).toEqual("1 Minute")
});
test("convert millseconds",()=>{
    expect(convertTime(3600000)).toEqual("1 Hours")
});
test("convert millseconds",()=>{
    expect(convertTime(36548961)).toEqual("10 Hours 09 Minutes 08 Seconds")
});
test("convert millseconds",()=>{
    expect(convertTime(72000)).toEqual("1 Minute 2 Seconds")
});
test("convert millseconds",()=>{
    expect(convertTime(5456565)).toEqual("01 Hours 30 Minutes 56 Seconds")
});
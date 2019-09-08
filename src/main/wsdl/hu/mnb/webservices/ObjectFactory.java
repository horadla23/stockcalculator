
package hu.mnb.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hu.mnb.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCurrenciesRequestBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrenciesRequestBody");
    private final static QName _GetCurrencies_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrencies");
    private final static QName _GetCurrenciesResponseBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrenciesResponseBody");
    private final static QName _GetCurrenciesResponse_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrenciesResponse");
    private final static QName _GetCurrencyUnitsRequestBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrencyUnitsRequestBody");
    private final static QName _GetCurrencyUnits_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrencyUnits");
    private final static QName _GetCurrencyUnitsResponseBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrencyUnitsResponseBody");
    private final static QName _GetCurrencyUnitsResponse_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrencyUnitsResponse");
    private final static QName _GetCurrentExchangeRatesRequestBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrentExchangeRatesRequestBody");
    private final static QName _GetCurrentExchangeRates_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrentExchangeRates");
    private final static QName _GetCurrentExchangeRatesResponseBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrentExchangeRatesResponseBody");
    private final static QName _GetCurrentExchangeRatesResponse_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrentExchangeRatesResponse");
    private final static QName _GetDateIntervalRequestBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetDateIntervalRequestBody");
    private final static QName _GetDateInterval_QNAME = new QName("http://www.mnb.hu/webservices/", "GetDateInterval");
    private final static QName _GetDateIntervalResponseBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetDateIntervalResponseBody");
    private final static QName _GetDateIntervalResponse_QNAME = new QName("http://www.mnb.hu/webservices/", "GetDateIntervalResponse");
    private final static QName _GetExchangeRatesRequestBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetExchangeRatesRequestBody");
    private final static QName _GetExchangeRates_QNAME = new QName("http://www.mnb.hu/webservices/", "GetExchangeRates");
    private final static QName _GetExchangeRatesResponseBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetExchangeRatesResponseBody");
    private final static QName _GetExchangeRatesResponse_QNAME = new QName("http://www.mnb.hu/webservices/", "GetExchangeRatesResponse");
    private final static QName _GetInfoRequestBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetInfoRequestBody");
    private final static QName _GetInfo_QNAME = new QName("http://www.mnb.hu/webservices/", "GetInfo");
    private final static QName _GetInfoResponseBody_QNAME = new QName("http://www.mnb.hu/webservices/", "GetInfoResponseBody");
    private final static QName _GetInfoResponse_QNAME = new QName("http://www.mnb.hu/webservices/", "GetInfoResponse");
    private final static QName _GetInfoResponseBodyGetInfoResult_QNAME = new QName("http://www.mnb.hu/webservices/", "GetInfoResult");
    private final static QName _GetExchangeRatesResponseBodyGetExchangeRatesResult_QNAME = new QName("http://www.mnb.hu/webservices/", "GetExchangeRatesResult");
    private final static QName _GetExchangeRatesRequestBodyStartDate_QNAME = new QName("http://www.mnb.hu/webservices/", "startDate");
    private final static QName _GetExchangeRatesRequestBodyEndDate_QNAME = new QName("http://www.mnb.hu/webservices/", "endDate");
    private final static QName _GetExchangeRatesRequestBodyCurrencyNames_QNAME = new QName("http://www.mnb.hu/webservices/", "currencyNames");
    private final static QName _GetDateIntervalResponseBodyGetDateIntervalResult_QNAME = new QName("http://www.mnb.hu/webservices/", "GetDateIntervalResult");
    private final static QName _GetCurrentExchangeRatesResponseBodyGetCurrentExchangeRatesResult_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrentExchangeRatesResult");
    private final static QName _GetCurrencyUnitsResponseBodyGetCurrencyUnitsResult_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrencyUnitsResult");
    private final static QName _GetCurrenciesResponseBodyGetCurrenciesResult_QNAME = new QName("http://www.mnb.hu/webservices/", "GetCurrenciesResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hu.mnb.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCurrenciesRequestBody }
     * 
     */
    public GetCurrenciesRequestBody createGetCurrenciesRequestBody() {
        return new GetCurrenciesRequestBody();
    }

    /**
     * Create an instance of {@link GetCurrenciesResponseBody }
     * 
     */
    public GetCurrenciesResponseBody createGetCurrenciesResponseBody() {
        return new GetCurrenciesResponseBody();
    }

    /**
     * Create an instance of {@link GetCurrencyUnitsRequestBody }
     * 
     */
    public GetCurrencyUnitsRequestBody createGetCurrencyUnitsRequestBody() {
        return new GetCurrencyUnitsRequestBody();
    }

    /**
     * Create an instance of {@link GetCurrencyUnitsResponseBody }
     * 
     */
    public GetCurrencyUnitsResponseBody createGetCurrencyUnitsResponseBody() {
        return new GetCurrencyUnitsResponseBody();
    }

    /**
     * Create an instance of {@link GetCurrentExchangeRatesRequestBody }
     * 
     */
    public GetCurrentExchangeRatesRequestBody createGetCurrentExchangeRatesRequestBody() {
        return new GetCurrentExchangeRatesRequestBody();
    }

    /**
     * Create an instance of {@link GetCurrentExchangeRatesResponseBody }
     * 
     */
    public GetCurrentExchangeRatesResponseBody createGetCurrentExchangeRatesResponseBody() {
        return new GetCurrentExchangeRatesResponseBody();
    }

    /**
     * Create an instance of {@link GetDateIntervalRequestBody }
     * 
     */
    public GetDateIntervalRequestBody createGetDateIntervalRequestBody() {
        return new GetDateIntervalRequestBody();
    }

    /**
     * Create an instance of {@link GetDateIntervalResponseBody }
     * 
     */
    public GetDateIntervalResponseBody createGetDateIntervalResponseBody() {
        return new GetDateIntervalResponseBody();
    }

    /**
     * Create an instance of {@link GetExchangeRatesRequestBody }
     * 
     */
    public GetExchangeRatesRequestBody createGetExchangeRatesRequestBody() {
        return new GetExchangeRatesRequestBody();
    }

    /**
     * Create an instance of {@link GetExchangeRatesResponseBody }
     * 
     */
    public GetExchangeRatesResponseBody createGetExchangeRatesResponseBody() {
        return new GetExchangeRatesResponseBody();
    }

    /**
     * Create an instance of {@link GetInfoRequestBody }
     * 
     */
    public GetInfoRequestBody createGetInfoRequestBody() {
        return new GetInfoRequestBody();
    }

    /**
     * Create an instance of {@link GetInfoResponseBody }
     * 
     */
    public GetInfoResponseBody createGetInfoResponseBody() {
        return new GetInfoResponseBody();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrenciesRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrenciesRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrenciesRequestBody")
    public JAXBElement<GetCurrenciesRequestBody> createGetCurrenciesRequestBody(GetCurrenciesRequestBody value) {
        return new JAXBElement<GetCurrenciesRequestBody>(_GetCurrenciesRequestBody_QNAME, GetCurrenciesRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrenciesRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrenciesRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrencies")
    public JAXBElement<GetCurrenciesRequestBody> createGetCurrencies(GetCurrenciesRequestBody value) {
        return new JAXBElement<GetCurrenciesRequestBody>(_GetCurrencies_QNAME, GetCurrenciesRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrenciesResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrenciesResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrenciesResponseBody")
    public JAXBElement<GetCurrenciesResponseBody> createGetCurrenciesResponseBody(GetCurrenciesResponseBody value) {
        return new JAXBElement<GetCurrenciesResponseBody>(_GetCurrenciesResponseBody_QNAME, GetCurrenciesResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrenciesResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrenciesResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrenciesResponse")
    public JAXBElement<GetCurrenciesResponseBody> createGetCurrenciesResponse(GetCurrenciesResponseBody value) {
        return new JAXBElement<GetCurrenciesResponseBody>(_GetCurrenciesResponse_QNAME, GetCurrenciesResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyUnitsRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrencyUnitsRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrencyUnitsRequestBody")
    public JAXBElement<GetCurrencyUnitsRequestBody> createGetCurrencyUnitsRequestBody(GetCurrencyUnitsRequestBody value) {
        return new JAXBElement<GetCurrencyUnitsRequestBody>(_GetCurrencyUnitsRequestBody_QNAME, GetCurrencyUnitsRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyUnitsRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrencyUnitsRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrencyUnits")
    public JAXBElement<GetCurrencyUnitsRequestBody> createGetCurrencyUnits(GetCurrencyUnitsRequestBody value) {
        return new JAXBElement<GetCurrencyUnitsRequestBody>(_GetCurrencyUnits_QNAME, GetCurrencyUnitsRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyUnitsResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrencyUnitsResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrencyUnitsResponseBody")
    public JAXBElement<GetCurrencyUnitsResponseBody> createGetCurrencyUnitsResponseBody(GetCurrencyUnitsResponseBody value) {
        return new JAXBElement<GetCurrencyUnitsResponseBody>(_GetCurrencyUnitsResponseBody_QNAME, GetCurrencyUnitsResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyUnitsResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrencyUnitsResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrencyUnitsResponse")
    public JAXBElement<GetCurrencyUnitsResponseBody> createGetCurrencyUnitsResponse(GetCurrencyUnitsResponseBody value) {
        return new JAXBElement<GetCurrencyUnitsResponseBody>(_GetCurrencyUnitsResponse_QNAME, GetCurrencyUnitsResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentExchangeRatesRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentExchangeRatesRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrentExchangeRatesRequestBody")
    public JAXBElement<GetCurrentExchangeRatesRequestBody> createGetCurrentExchangeRatesRequestBody(GetCurrentExchangeRatesRequestBody value) {
        return new JAXBElement<GetCurrentExchangeRatesRequestBody>(_GetCurrentExchangeRatesRequestBody_QNAME, GetCurrentExchangeRatesRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentExchangeRatesRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentExchangeRatesRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrentExchangeRates")
    public JAXBElement<GetCurrentExchangeRatesRequestBody> createGetCurrentExchangeRates(GetCurrentExchangeRatesRequestBody value) {
        return new JAXBElement<GetCurrentExchangeRatesRequestBody>(_GetCurrentExchangeRates_QNAME, GetCurrentExchangeRatesRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentExchangeRatesResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentExchangeRatesResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrentExchangeRatesResponseBody")
    public JAXBElement<GetCurrentExchangeRatesResponseBody> createGetCurrentExchangeRatesResponseBody(GetCurrentExchangeRatesResponseBody value) {
        return new JAXBElement<GetCurrentExchangeRatesResponseBody>(_GetCurrentExchangeRatesResponseBody_QNAME, GetCurrentExchangeRatesResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrentExchangeRatesResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCurrentExchangeRatesResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrentExchangeRatesResponse")
    public JAXBElement<GetCurrentExchangeRatesResponseBody> createGetCurrentExchangeRatesResponse(GetCurrentExchangeRatesResponseBody value) {
        return new JAXBElement<GetCurrentExchangeRatesResponseBody>(_GetCurrentExchangeRatesResponse_QNAME, GetCurrentExchangeRatesResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDateIntervalRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDateIntervalRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetDateIntervalRequestBody")
    public JAXBElement<GetDateIntervalRequestBody> createGetDateIntervalRequestBody(GetDateIntervalRequestBody value) {
        return new JAXBElement<GetDateIntervalRequestBody>(_GetDateIntervalRequestBody_QNAME, GetDateIntervalRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDateIntervalRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDateIntervalRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetDateInterval")
    public JAXBElement<GetDateIntervalRequestBody> createGetDateInterval(GetDateIntervalRequestBody value) {
        return new JAXBElement<GetDateIntervalRequestBody>(_GetDateInterval_QNAME, GetDateIntervalRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDateIntervalResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDateIntervalResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetDateIntervalResponseBody")
    public JAXBElement<GetDateIntervalResponseBody> createGetDateIntervalResponseBody(GetDateIntervalResponseBody value) {
        return new JAXBElement<GetDateIntervalResponseBody>(_GetDateIntervalResponseBody_QNAME, GetDateIntervalResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDateIntervalResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDateIntervalResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetDateIntervalResponse")
    public JAXBElement<GetDateIntervalResponseBody> createGetDateIntervalResponse(GetDateIntervalResponseBody value) {
        return new JAXBElement<GetDateIntervalResponseBody>(_GetDateIntervalResponse_QNAME, GetDateIntervalResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExchangeRatesRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetExchangeRatesRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetExchangeRatesRequestBody")
    public JAXBElement<GetExchangeRatesRequestBody> createGetExchangeRatesRequestBody(GetExchangeRatesRequestBody value) {
        return new JAXBElement<GetExchangeRatesRequestBody>(_GetExchangeRatesRequestBody_QNAME, GetExchangeRatesRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExchangeRatesRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetExchangeRatesRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetExchangeRates")
    public JAXBElement<GetExchangeRatesRequestBody> createGetExchangeRates(GetExchangeRatesRequestBody value) {
        return new JAXBElement<GetExchangeRatesRequestBody>(_GetExchangeRates_QNAME, GetExchangeRatesRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExchangeRatesResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetExchangeRatesResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetExchangeRatesResponseBody")
    public JAXBElement<GetExchangeRatesResponseBody> createGetExchangeRatesResponseBody(GetExchangeRatesResponseBody value) {
        return new JAXBElement<GetExchangeRatesResponseBody>(_GetExchangeRatesResponseBody_QNAME, GetExchangeRatesResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetExchangeRatesResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetExchangeRatesResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetExchangeRatesResponse")
    public JAXBElement<GetExchangeRatesResponseBody> createGetExchangeRatesResponse(GetExchangeRatesResponseBody value) {
        return new JAXBElement<GetExchangeRatesResponseBody>(_GetExchangeRatesResponse_QNAME, GetExchangeRatesResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfoRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetInfoRequestBody")
    public JAXBElement<GetInfoRequestBody> createGetInfoRequestBody(GetInfoRequestBody value) {
        return new JAXBElement<GetInfoRequestBody>(_GetInfoRequestBody_QNAME, GetInfoRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoRequestBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfoRequestBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetInfo")
    public JAXBElement<GetInfoRequestBody> createGetInfo(GetInfoRequestBody value) {
        return new JAXBElement<GetInfoRequestBody>(_GetInfo_QNAME, GetInfoRequestBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfoResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetInfoResponseBody")
    public JAXBElement<GetInfoResponseBody> createGetInfoResponseBody(GetInfoResponseBody value) {
        return new JAXBElement<GetInfoResponseBody>(_GetInfoResponseBody_QNAME, GetInfoResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoResponseBody }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfoResponseBody }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetInfoResponse")
    public JAXBElement<GetInfoResponseBody> createGetInfoResponse(GetInfoResponseBody value) {
        return new JAXBElement<GetInfoResponseBody>(_GetInfoResponse_QNAME, GetInfoResponseBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetInfoResult", scope = GetInfoResponseBody.class)
    public JAXBElement<String> createGetInfoResponseBodyGetInfoResult(String value) {
        return new JAXBElement<String>(_GetInfoResponseBodyGetInfoResult_QNAME, String.class, GetInfoResponseBody.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetExchangeRatesResult", scope = GetExchangeRatesResponseBody.class)
    public JAXBElement<String> createGetExchangeRatesResponseBodyGetExchangeRatesResult(String value) {
        return new JAXBElement<String>(_GetExchangeRatesResponseBodyGetExchangeRatesResult_QNAME, String.class, GetExchangeRatesResponseBody.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "startDate", scope = GetExchangeRatesRequestBody.class)
    public JAXBElement<String> createGetExchangeRatesRequestBodyStartDate(String value) {
        return new JAXBElement<String>(_GetExchangeRatesRequestBodyStartDate_QNAME, String.class, GetExchangeRatesRequestBody.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "endDate", scope = GetExchangeRatesRequestBody.class)
    public JAXBElement<String> createGetExchangeRatesRequestBodyEndDate(String value) {
        return new JAXBElement<String>(_GetExchangeRatesRequestBodyEndDate_QNAME, String.class, GetExchangeRatesRequestBody.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "currencyNames", scope = GetExchangeRatesRequestBody.class)
    public JAXBElement<String> createGetExchangeRatesRequestBodyCurrencyNames(String value) {
        return new JAXBElement<String>(_GetExchangeRatesRequestBodyCurrencyNames_QNAME, String.class, GetExchangeRatesRequestBody.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetDateIntervalResult", scope = GetDateIntervalResponseBody.class)
    public JAXBElement<String> createGetDateIntervalResponseBodyGetDateIntervalResult(String value) {
        return new JAXBElement<String>(_GetDateIntervalResponseBodyGetDateIntervalResult_QNAME, String.class, GetDateIntervalResponseBody.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrentExchangeRatesResult", scope = GetCurrentExchangeRatesResponseBody.class)
    public JAXBElement<String> createGetCurrentExchangeRatesResponseBodyGetCurrentExchangeRatesResult(String value) {
        return new JAXBElement<String>(_GetCurrentExchangeRatesResponseBodyGetCurrentExchangeRatesResult_QNAME, String.class, GetCurrentExchangeRatesResponseBody.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrencyUnitsResult", scope = GetCurrencyUnitsResponseBody.class)
    public JAXBElement<String> createGetCurrencyUnitsResponseBodyGetCurrencyUnitsResult(String value) {
        return new JAXBElement<String>(_GetCurrencyUnitsResponseBodyGetCurrencyUnitsResult_QNAME, String.class, GetCurrencyUnitsResponseBody.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "currencyNames", scope = GetCurrencyUnitsRequestBody.class)
    public JAXBElement<String> createGetCurrencyUnitsRequestBodyCurrencyNames(String value) {
        return new JAXBElement<String>(_GetExchangeRatesRequestBodyCurrencyNames_QNAME, String.class, GetCurrencyUnitsRequestBody.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.mnb.hu/webservices/", name = "GetCurrenciesResult", scope = GetCurrenciesResponseBody.class)
    public JAXBElement<String> createGetCurrenciesResponseBodyGetCurrenciesResult(String value) {
        return new JAXBElement<String>(_GetCurrenciesResponseBodyGetCurrenciesResult_QNAME, String.class, GetCurrenciesResponseBody.class, value);
    }

}

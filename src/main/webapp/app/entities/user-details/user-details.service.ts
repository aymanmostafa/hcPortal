import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { JhiDateUtils } from 'ng-jhipster';

import { UserDetails } from './user-details.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<UserDetails>;

@Injectable()
export class UserDetailsService {

    private resourceUrl =  SERVER_API_URL + 'api/user-details';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils) { }

    create(userDetails: UserDetails): Observable<EntityResponseType> {
        const copy = this.convert(userDetails);
        return this.http.post<UserDetails>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(userDetails: UserDetails): Observable<EntityResponseType> {
        const copy = this.convert(userDetails);
        return this.http.put<UserDetails>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: string): Observable<EntityResponseType> {
        return this.http.get<UserDetails>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<UserDetails[]>> {
        const options = createRequestOption(req);
        return this.http.get<UserDetails[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<UserDetails[]>) => this.convertArrayResponse(res));
    }

    delete(id: string): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: UserDetails = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<UserDetails[]>): HttpResponse<UserDetails[]> {
        const jsonResponse: UserDetails[] = res.body;
        const body: UserDetails[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to UserDetails.
     */
    private convertItemFromServer(userDetails: UserDetails): UserDetails {
        const copy: UserDetails = Object.assign({}, userDetails);
        copy.birthdate = this.dateUtils
            .convertLocalDateFromServer(userDetails.birthdate);
        copy.resetdate = this.dateUtils
            .convertLocalDateFromServer(userDetails.resetdate);
        return copy;
    }

    /**
     * Convert a UserDetails to a JSON which can be sent to the server.
     */
    private convert(userDetails: UserDetails): UserDetails {
        const copy: UserDetails = Object.assign({}, userDetails);
        copy.birthdate = this.dateUtils
            .convertLocalDateToServer(userDetails.birthdate);
        copy.resetdate = this.dateUtils
            .convertLocalDateToServer(userDetails.resetdate);
        return copy;
    }
}

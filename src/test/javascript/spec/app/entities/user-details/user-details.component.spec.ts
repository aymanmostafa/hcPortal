/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { UserDetailsComponent } from '../../../../../../main/webapp/app/entities/user-details/user-details.component';
import { UserDetailsService } from '../../../../../../main/webapp/app/entities/user-details/user-details.service';
import { UserDetails } from '../../../../../../main/webapp/app/entities/user-details/user-details.model';

describe('Component Tests', () => {

    describe('UserDetails Management Component', () => {
        let comp: UserDetailsComponent;
        let fixture: ComponentFixture<UserDetailsComponent>;
        let service: UserDetailsService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [UserDetailsComponent],
                providers: [
                    UserDetailsService
                ]
            })
            .overrideTemplate(UserDetailsComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(UserDetailsComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(UserDetailsService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new UserDetails('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.userDetails[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});

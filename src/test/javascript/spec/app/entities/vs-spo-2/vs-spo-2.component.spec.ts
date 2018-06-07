/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { VsSpo2Component } from '../../../../../../main/webapp/app/entities/vs-spo-2/vs-spo-2.component';
import { VsSpo2Service } from '../../../../../../main/webapp/app/entities/vs-spo-2/vs-spo-2.service';
import { VsSpo2 } from '../../../../../../main/webapp/app/entities/vs-spo-2/vs-spo-2.model';

describe('Component Tests', () => {

    describe('VsSpo2 Management Component', () => {
        let comp: VsSpo2Component;
        let fixture: ComponentFixture<VsSpo2Component>;
        let service: VsSpo2Service;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsSpo2Component],
                providers: [
                    VsSpo2Service
                ]
            })
            .overrideTemplate(VsSpo2Component, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsSpo2Component);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsSpo2Service);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new VsSpo2('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.vsSpo2S[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});

/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { VsRespiratoryRateComponent } from '../../../../../../main/webapp/app/entities/vs-respiratory-rate/vs-respiratory-rate.component';
import { VsRespiratoryRateService } from '../../../../../../main/webapp/app/entities/vs-respiratory-rate/vs-respiratory-rate.service';
import { VsRespiratoryRate } from '../../../../../../main/webapp/app/entities/vs-respiratory-rate/vs-respiratory-rate.model';

describe('Component Tests', () => {

    describe('VsRespiratoryRate Management Component', () => {
        let comp: VsRespiratoryRateComponent;
        let fixture: ComponentFixture<VsRespiratoryRateComponent>;
        let service: VsRespiratoryRateService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsRespiratoryRateComponent],
                providers: [
                    VsRespiratoryRateService
                ]
            })
            .overrideTemplate(VsRespiratoryRateComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsRespiratoryRateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsRespiratoryRateService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new VsRespiratoryRate('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.vsRespiratoryRates[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
